package com.myproject.assist.controller;

import java.util.ArrayList;

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
import com.myproject.assist.model.service.MentionTypeService;

@Controller
@RequestMapping(value = "/constructure")
public class ConstructureController {
	
	@Autowired
	@Qualifier("mentionTypeService")
	private MentionTypeService mentionTypeService;

	@RequestMapping(value="mentionTypeCheck.action", method=RequestMethod.GET)
	public String mentionTypeCheckPage(HttpSession session) {
		ArrayList<String> folderList = FileUtil.getFolderList(FilePath.path.folderPath);
		session.setAttribute("folderList", folderList);
		return "error/mentionType";
	}
	
	@RequestMapping(value="folderList.action", method = RequestMethod.GET, produces = "applications/json;charset=utf-8")
	@ResponseBody
	public String getNextFolderList(HttpServletResponse resp, String folderName) {
		ArrayList<String> folderList = FileUtil.getFolderList(FilePath.path.folderPath + "/" + folderName);
		
		if(folderList.size() == 0) {
			folderList.add("=======================");
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(folderList);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}
	
	@RequestMapping(value="missingMentionTypeCheck.action", method = RequestMethod.GET, produces = "applications/json;charset=utf-8")
	@ResponseBody
	public String getResultMentionTypeCheck(HttpServletResponse resp, String folderName, String nextPath) {
		
		ArrayList<ArrayList<String>> result = mentionTypeService.missingMentionTypeCheck(folderName, nextPath);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json =gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}
	
	@RequestMapping(value="addedMentionTypeCheck.action", method = RequestMethod.GET, produces = "applications/json;charset=utf-8")
	@ResponseBody
	public String getResultMentionTypeCheck2(HttpServletResponse resp, String folderName, String nextPath) {
		
		ArrayList<ArrayList<String>> result = mentionTypeService.addedMentionTypeCheck(folderName, nextPath);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json =gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}

}