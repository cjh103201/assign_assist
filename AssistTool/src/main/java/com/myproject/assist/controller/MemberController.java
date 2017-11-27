package com.myproject.assist.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.assist.model.dto.Member;
import com.myproject.assist.model.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	@RequestMapping(value="register.action", method=RequestMethod.POST)
	public String register(Member member, HttpServletResponse resp) {
		Member members = memberService.getMemberById(member.getId());
		if(members != null) {
			try {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('이미 존재하는 아이디입니다. 다른 아이디를 입력하세요. ');history.go(-1);</script>");
				out.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return "index";
		} else {
			memberService.registerMember(member);
			return "redirect:/home.action";
		}
	}
	
}