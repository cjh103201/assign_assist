package com.myproject.assist.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;

@Service("concordanceService")
public class ConcordanceServiceImpl implements ConcordanceService {

	@Override
	public ArrayList<ArrayList<String>> textConcordance(String text) {
		System.out.println(text);
		String lowerText = text.toLowerCase();
		String path = FilePath.path.allFilePath;
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> txtFileList = FileUtil.getTextFileList(path);
		for(String fileName : txtFileList) {
			ArrayList<String> lines = FileUtil.readFileData(path, fileName);
			
			for(int i = 0; i<lines.size(); i++) {
				String line = lines.get(i).toLowerCase();
				if(line.contains(lowerText)) {
					ArrayList<String> cons = new ArrayList<>();
					cons.add(fileName.substring(0, fileName.length()-4));
					cons.add(String.valueOf((i+1)));
//					cons.add(lines.get(i));
					cons.add(lines.get(i).replaceAll("(?i)"+text, "<span style='color:red'>" + text +"</span>"));
					result.add(cons);
				}
			}
		}
		return result;
	}

	//모든 종류의 엔터티 조회
	@Override
	public ArrayList<ArrayList<String>> allEntityConcordance() {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	//유형에 맞는 엔터티 조회 
	@Override
	public ArrayList<ArrayList<String>> concordanceWithEntityType(String type) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	//검색어에 맞는 엔터티 조
	@Override
	public ArrayList<ArrayList<String>> concordanceWithWord(String text) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> EntityConcordance(String type, String text) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> allEventConcordance() {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithEventType(String type) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithEventWord(String text) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> EventConcordance(String type, String text) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return result;
	}

}
