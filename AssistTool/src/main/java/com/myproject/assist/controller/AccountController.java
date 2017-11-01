package com.myproject.assist.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.assist.model.dto.Member;
import com.myproject.assist.model.service.MemberService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	//로그인
	@RequestMapping(value="login.action", method=RequestMethod.POST)
	public String login(String loginid, String loginpassword, HttpSession session, HttpServletResponse resp) {
		System.out.println(loginid);
		Member member = memberService.getMemberByIdAndPassword(loginid, loginpassword);
		
		if(member == null) {
			try {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('아이디와 비밀번호를 확인해주세요.');history.go(-1);</script>");
				out.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return "index";
		} else {
			session.setAttribute("loginuser", member);
			return "redirect:/home.action";
		}
	}
	
	@RequestMapping(value="logout.action", method = RequestMethod.GET)
	public String login(HttpSession session) {
		
		session.removeAttribute("loginuser");
		
		return "redirect:/home.action";
	}
	
}