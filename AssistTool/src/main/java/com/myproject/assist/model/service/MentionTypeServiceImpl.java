package com.myproject.assist.model.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;

@Service("mentionTypeService")
public class MentionTypeServiceImpl implements MentionTypeService {

	@Override
	public ArrayList<ArrayList<String>> missingMentionTypeCheck(String folderName, String nextPath) {
		String path = FilePath.path.folderPath + "/" + folderName + nextPath;
		
		//result 데이터
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		for(String fileName : annFileList) {
			HashSet<String> entitySet = new HashSet<>();
			HashSet<String> empty = new HashSet<>();
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i < content.size(); i++) {
				String attr = content.get(i)[1];
				if(attr.equals("DIS") || attr.equals("PER") || attr.equals("PGEN") || attr.equals("ORG") || attr.equals("GPE") || attr.equals("LOC") || attr.equals("FAC")) {
					entitySet.add(content.get(i)[0]);
				}
			}
			
			for(int i=0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("A")) {
					for(String entity : entitySet) {
						if(content.get(i)[2].equals(entity)) {
							empty.add(entity);
						}
					}
				}
			}
			
			for(String emp : empty) {
				entitySet.remove(emp);
			}
			
			if(entitySet.size() != 0) {
				for(int i=0; i<content.size(); i++) {
					for(String entity : entitySet) {
						if(content.get(i)[0].equals(entity)) {
							ArrayList<String> cont = new ArrayList<>();
							cont.add(fileName.substring(0, fileName.length() - 4));
							cont.add(FileUtil.getLine(path, fileName, content.get(i)));
							cont.add(content.get(i)[1]);
							cont.add(FileUtil.getWord(content.get(i)));
							result.add(cont);
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> addedMentionTypeCheck(String folderName, String nextPath) {
		String path = FilePath.path.folderPath + "/" + folderName + nextPath;
		
		//result 데이터
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		for(String fileName : annFileList) {
			HashSet<String> entitySet = new HashSet<>();
			HashSet<String> added = new HashSet<>();
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i=0; i<content.size(); i++) {
				String attr = content.get(i)[1];
				if(attr.equals("NPER") || attr.equals("SYMP") || attr.equals("TIME")) {
					entitySet.add(content.get(i)[0]);
				}
			}
			
			for(int i=0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("A")) {
					for(String entity : entitySet) {
						if(content.get(i)[2].equals(entity)) {
							added.add(entity);
						}
					}
				}
			}
			
			if(added.size() != 0) {
				for(int i=0; i<content.size(); i++) {
					for(String entity : entitySet) {
						if(content.get(i)[0].equals(entity)) {
							ArrayList<String> cont = new ArrayList<>();
							cont.add(fileName.substring(0, fileName.length() - 4));
							cont.add(FileUtil.getLine(path, fileName, content.get(i)));
							cont.add(content.get(i)[1]);
							cont.add(FileUtil.getWord(content.get(i)));
							result.add(cont);
						}
					}
				}
			}
		}
		return result;
	}
}
