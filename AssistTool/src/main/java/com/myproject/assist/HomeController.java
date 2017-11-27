package com.myproject.assist;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
			
			return "home";
		}
	}
	
	@RequestMapping(value="newsCounting.action", method=RequestMethod.GET, produces="applications/json;charset=utf-8")
	@ResponseBody
	public String nesCounting(HttpServletResponse resp, String text) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(countingService.getNewsDocNum());
		result.add(countingService.getNewsNoDocNum());
		result.add(countingService.getNewsDocNum()-countingService.getNewsNoDocNum());
		result.add(countingService.getNewsEventNum());
		result.add(countingService.getNewsDistinctEventNum());
		result.add(countingService.getNewsEntityNum());
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}
	
	@RequestMapping(value="promedCounting.action", method=RequestMethod.GET, produces="applications/json;charset=utf-8")
	@ResponseBody
	public String promedCounting(HttpServletResponse resp, String text) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(countingService.getPromedDocNum());
		result.add(countingService.getPromedNoDocNum());
		result.add(countingService.getPromedDocNum() - countingService.getPromedNoDocNum());
		result.add(countingService.getPromedEventNum());
		result.add(countingService.getPromedDistinctEventNum());
		result.add(countingService.getPromedEntityNum());
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}
	
}
