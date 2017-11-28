package com.myproject.assist.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;
import com.myproject.assist.model.dto.Assign;
import com.myproject.assist.model.dto.Member;
import com.myproject.assist.model.service.AssignService;
import com.myproject.assist.model.service.MemberService;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;
	
	@Autowired
	@Qualifier("assignService")
	private AssignService assignService;

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
			ArrayList<String> folderList = FileUtil.getFolderList(FilePath.path.workingPath);
			session.setAttribute("folderList", folderList);
			session.setAttribute("members", memberService.getWorkerList());
			
			return "manage/assignWork";			
		} else {
			List<Assign> assignList = assignService.getAssignListByID(member.getId());
			session.setAttribute("assignList", assignList);
			
			return "manage/worker";
		}
	}
	
	@RequestMapping(value="fileList.action", method=RequestMethod.GET, produces="applications/json;charset=utf-8")
	@ResponseBody
	public String getFileList(String folderName, HttpServletResponse resp) {
		ArrayList<String> fileList = FileUtil.getTextFileList(FilePath.path.workingPath + "/" + folderName + "/1st");
		Collections.sort(fileList);
		List<Assign> assignList = assignService.getAssignList();
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if(fileList.size() == 0) {
			fileList.add("=============");
		} else {
			/*for(String file : fileList) {
				ArrayList<String> cont = new ArrayList<>();
				cont.add(file);
				for(Assign assign : assignList) {
					if(file.equals(assign.getFileName())) {
						if(assign.getStep().equals("1st")) {
							cont.add(assign.getStep());
							cont.add(assign.getWorker());
						} else if(assign.getStep().equals("2nd")) {
							cont.add(assign.getStep());
							cont.add(assign.getWorker());
						} else {
							cont.add(assign.getStep());
							cont.add(assign.getWorker());
						}
					}
					result.add(cont);
				}
			} */
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8"); 
		
		return json;
	}
	
	@RequestMapping(value="assignWork.action", method=RequestMethod.GET, produces="applications/json;charset=utf-8")
	@ResponseBody
	public String AssignWork(Assign assign, HttpSession session, HttpServletResponse resp) {
		Member member = (Member)session.getAttribute("loginuser");
		assign.setManager(member.getId());
		assignService.registerAssign(assign);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson("success");
		
		resp.setContentType("application/json;charset=utf-8"); 
		
		return json;
	}
}
