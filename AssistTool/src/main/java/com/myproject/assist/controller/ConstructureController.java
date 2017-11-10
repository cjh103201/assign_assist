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
import com.myproject.assist.model.service.ConstructureService;

@Controller
@RequestMapping(value = "/constructure")
public class ConstructureController {
	
	@Autowired
	@Qualifier("constructureService")
	private ConstructureService constructurService;
	
	@RequestMapping(value="constructureCheck.action", method=RequestMethod.GET)
	public String ConstructureCheckPage(HttpSession session) {
		ArrayList<String> folderList = FileUtil.getFolderList(FilePath.path.folderPath);
		session.setAttribute("folderList", folderList);
		return "error/constructure";
	}
	
	@RequestMapping(value="folderList.action", method=RequestMethod.GET, produces="applications/json;charset=utf-8")
	@ResponseBody
	public String GetNextFolderList(String folderName, HttpServletResponse resp) {
		ArrayList<String> folderList = FileUtil.getFolderList(FilePath.path.folderPath + "/" + folderName);
		
		if(folderList.size() == 0) {
			folderList.add("=======================");
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(folderList);
		
		resp.setContentType("application/json;charset=utf-8"); 
		
		return json;
	}
	
	@RequestMapping(value="CheckConstructureLack.action", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public String CheckConstructureOfLack(HttpServletResponse resp, String folderName, String nextPath) {
		ArrayList<ArrayList<String>> result = constructurService.CheckConstructureOfLack(folderName, nextPath);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json =gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}

	@RequestMapping(value="CheckConstructureMismatch.action", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public String CheckConstructureOfMismatch(HttpServletResponse resp, String folderName, String nextPath) {
		ArrayList<ArrayList<String>> result = constructurService.CheckConstructureOfMismatch(folderName, nextPath);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json =gson.toJson(result);
		
		resp.setContentType("application/json;charset=utf-8");
		
		return json;
	}

}