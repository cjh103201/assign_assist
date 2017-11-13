package com.myproject.assist.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;

@Service("concordanceService")
public class ConcordanceServiceImpl implements ConcordanceService {

	@Override
	public ArrayList<ArrayList<String>> textConcordance(String text) {

		String path = FilePath.path.allFilePath;
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> txtFileList = FileUtil.getTextFileList(path);
		for(String fileName : txtFileList) {
			ArrayList<String> lines = FileUtil.readFileData(path, fileName);
			
			for(int i = 0; i<lines.size(); i++) {
				String line = lines.get(i).toLowerCase();
				if(line.contains(text)) {
					ArrayList<String> cons = new ArrayList<>();
					cons.add(fileName.substring(0, fileName.length()-4));
					cons.add(String.valueOf((i+1)));
					cons.add(lines.get(i));
					result.add(cons);
				}
			}
			
		}
		
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> allEntityConcordance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithEntityType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithWord(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> EntityConcordance(String type, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> allEventConcordance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithEventType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> concordanceWithEventWord(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<String>> EventConcordance(String type, String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
