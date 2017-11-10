package com.myproject.assist.model.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;

@Service("constructureService")
public class ConstructureServiceImpl implements ConstructureService {

	@Override
	public ArrayList<ArrayList<String>> CheckConstructureOfLack(String folderName, String nextPath) {
		//경로 설정
		String path = FilePath.path.folderPath + "/" + folderName + nextPath;
		
		//result data
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("E")) {
					ArrayList<String> cont = new ArrayList<>();
					if(content.get(i).length < 7) {
						cont.add(fileName.substring(0, fileName.length() - 4));
						cont.add(FileUtil.getLine(path, fileName, content.get(i)));
						cont.add(content.get(i)[1] + "[필수 요소 부족]");
						cont.add(FileUtil.getWord(content.get(i)));
						result.add(cont);
					} else {
						HashSet<String> tmp = new HashSet<>();
						for(int j = 3; j<content.get(i).length; j++) {
							tmp.add(content.get(i)[j]);
						}
						
						if(content.get(i)[1].equals("Announce")) {
							if(!tmp.contains("Event")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(content.get(i)[1] + "[Event 부족]");
								cont.add(FileUtil.getWord(content.get(i)));
								result.add(cont);
							} else if( !tmp.contains("Speaker")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(content.get(i)[1] + "[Speaker 부족]");
								cont.add(FileUtil.getWord(content.get(i)));
								result.add(cont);
							}
						} else {
							if(!tmp.contains("Disease")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(content.get(i)[1] + "[Disease 부족]");
								cont.add(FileUtil.getWord(content.get(i)));
								result.add(cont);
							}
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public ArrayList<ArrayList<String>> CheckConstructureOfMismatch(String folderName, String nextPath) {
		//경로 설정
		String path = FilePath.path.folderPath + "/" + folderName + nextPath;
		
		//result data
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("E") && content.get(i).length > 6 ) {
					for(int j = 1; j < content.get(i).length; j+=2) {
						ArrayList<String> cont = new ArrayList<>();
						String word = content.get(i)[j];
						String[] contentLine = FileUtil.getContentLineByEntityNo(content.get(i)[j+1], content);
						if(word.equals("Victim")) {
							if(!contentLine[1].equals("PER") && !contentLine[1].equals("NPER")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						} else if(word.contains("Time")) {
							if(!contentLine[1].equals("TIME")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						} else if (word.contains("Disease")) {
							if(!contentLine[1].equals("DIS") && !contentLine[1].equals("PGEN")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						} else if(word.contains("Place")) {
							if(!contentLine[1].equals("GPE") && !contentLine[1].equals("LOC") && !contentLine[1].equals("FAC")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						} else if(word.contains("Suffer")) {
							if(!contentLine[1].equals("SYMP")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						} else if(word.contains("Speaker")) {
							if(!contentLine[1].equals("PER") && !contentLine[1].equals("ORG")) {
								cont.add(fileName.substring(0, fileName.length() - 4));
								cont.add(FileUtil.getLine(path, fileName, content.get(i)));
								cont.add(contentLine[1]);
								cont.add(FileUtil.getWord(contentLine));
								result.add(cont);
							}
						}
					}
				}
			}
		}
		return result;
	}
}
