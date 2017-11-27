package com.myproject.assist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.assist.model.dto.Member;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		
		boolean redirect = false;
		String url = req.getRequestURI();
		System.out.println(url);
		
		if(url.contains("home") || url.contains("mentionType") || url.contains("constructure") || url.contains("concordance") || url.contains("fixDragging") || url.contains("management")) {
			if(req.getSession().getAttribute("loginuser") == null) {
				redirect = true;
			}
		}

		if(redirect) {
			resp.sendRedirect("/assist/");
		}
		
		return !redirect; //false가 반환되면 요청 처리 중
	}

	
}
