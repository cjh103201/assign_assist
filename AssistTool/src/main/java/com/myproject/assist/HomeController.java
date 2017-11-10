package com.myproject.assist;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.assist.model.service.CountingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("countingService")
	private CountingService countingService;
	
	@RequestMapping(value = {"/", "home.action" }, method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpSession session, Locale locale, Model model) {
		
		if(req.getSession().getAttribute("loginuser") == null) {
			return "index";
		} else {
			//all
			session.setAttribute("totalDocNum", countingService.getTotalDocNum());
			session.setAttribute("totalNoDocNum", countingService.getTotalNoDocNum());
			session.setAttribute("totalEventNum", countingService.getTotalEventNum());
			session.setAttribute("totalDistinctEventNum", countingService.getTotalDistinctEventNum());
			session.setAttribute("totalEntityNum", countingService.getTotalEntityNum());
			session.setAttribute("totalEventDocNo", countingService.getTotalDocNum() - countingService.getTotalNoDocNum());
			
			//news
			session.setAttribute("newsDocNum", countingService.getNewsDocNum());
			session.setAttribute("newsNoDocNum", countingService.getNewsNoDocNum());
			session.setAttribute("newsEventNum", countingService.getNewsEventNum());
			session.setAttribute("newsDistinctEventNum", countingService.getNewsDistinctEventNum());
			session.setAttribute("newsEntityNum", countingService.getNewsEntityNum());
			session.setAttribute("newsEventDocNo", countingService.getNewsDocNum() - countingService.getNewsNoDocNum());
			
			//promed
			session.setAttribute("promedDocNum", countingService.getPromedDocNum());
			session.setAttribute("promedNoDocNum", countingService.getPromedNoDocNum());
			session.setAttribute("promedEventNum", countingService.getPromedEventNum());
			session.setAttribute("promedDistinctEventNum", countingService.getPromedDistinctEventNum());
			session.setAttribute("promedEntityNum", countingService.getPromedEntityNum());
			session.setAttribute("promedEventDocNo", countingService.getPromedDocNum() - countingService.getPromedNoDocNum());

			
			return "home";
		}
	}
	
}
