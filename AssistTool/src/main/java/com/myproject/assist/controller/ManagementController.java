package com.myproject.assist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.assist.model.dto.Member;
import com.myproject.assist.model.service.MemberService;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	@RequestMapping(value="goUserManagement.action", method=RequestMethod.GET)
	public String goUserManagement(HttpSession session) {
		List<Member> members = memberService.getMemberList();
		session.setAttribute("Members", members);
		return "manage/user";
	}
	
	@RequestMapping(value="changeUserType.action", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public void ChangeUserType(String mId, String mUserType) {
		memberService.changeUserType(mId, mUserType);
	}
	
	@RequestMapping(value="deleteMember.action", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public void DeleteMember(String mId) {
		memberService.deleteMember(mId);
	}

	@RequestMapping(value="goAssignWork.action", method=RequestMethod.GET)
	public String goAssignWork(HttpSession session) {
		Member member = (Member)session.getAttribute("loginuser");
		if(member.getUserType() == 2) {
			return "manage/assignWork";			
		} else {
			return "manage/workStatus";
		}
	}
}
