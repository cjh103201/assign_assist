package com.myproject.assist.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.myproject.assist.common.FilePath;
import com.myproject.assist.common.FileUtil;

@Service("countingService")
public class CountingServiceImpl implements CountingService {

	@Override
	public int getTotalDocNum() {
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		return annFileList.size();
	}

	@Override
	public int getTotalNoDocNum() {
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("E")) {
					result++;
					break;
				}
			}
		}
		return annFileList.size() - result;
	}

	@Override
	public int getTotalEventNum() {
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("E")) {
					result++;
				}
			}
		}
		return result;
	}

	@Override
	public int getTotalDistinctEventNum() {
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileDataExceptEvent(FileUtil.readFileData(path, fileName));
			HashSet<String> eventSet = new HashSet<>();
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("E")) {
					eventSet.add(content.get(i)[1]);
				}
			}
			result += eventSet.size();
		}
		return result;
	}

	@Override
	public int getTotalEntityNum() {
		String path = FilePath.path.allFilePath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			//읽어온 데이터
			ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
			
			for(int i = 0; i<content.size(); i++) {
				if(content.get(i)[0].substring(0, 1).equals("T")) {
					result++;
				}
			}
		}
		return result;
	}

	@Override
	public int getNewsDocNum() {
		String path = FilePath.path.newsPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(fileName.contains("1488") || fileName.contains("1501")) {
				result++;
			}
		}
		
		return result;
	}

	@Override
	public int getNewsNoDocNum() {
		String path = FilePath.path.newsPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(fileName.contains("1488") || fileName.contains("1501")) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						result++;
						break;
					}
				}
			}
		}
		
		return annFileList.size() - result;
	}

	@Override
	public int getNewsEventNum() {
		String path = FilePath.path.newsPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(fileName.contains("1488") || fileName.contains("1501")) {
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						result++;
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public int getNewsDistinctEventNum() {
		String path = FilePath.path.newsPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(fileName.contains("1488") || fileName.contains("1501")) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileDataExceptEvent(FileUtil.readFileData(path, fileName));
				HashSet<String> eventSet = new HashSet<>();
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						eventSet.add(content.get(i)[1]);
					}
				}
				result += eventSet.size();
			}
		}
		
		return result;
	}

	@Override
	public int getNewsEntityNum() {
		String path = FilePath.path.newsPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(fileName.contains("1488") || fileName.contains("1501") ) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("T")) {
						result++;
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public int getPromedDocNum() {
		String path = FilePath.path.promedPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(!fileName.contains("1488") && !fileName.contains("1501") ) {
				result++;
			}
		}
		
		return result;
	}

	@Override
	public int getPromedNoDocNum() {
		String path = FilePath.path.promedPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(!fileName.contains("1488") && !fileName.contains("1501") ) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						result++;
						break;
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public int getPromedEventNum() {
		String path = FilePath.path.promedPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(!fileName.contains("1488") && !fileName.contains("1501") ) {
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						result++;
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public int getPromedDistinctEventNum() {
		String path = FilePath.path.promedPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(!fileName.contains("1488") && !fileName.contains("1501") ) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileDataExceptEvent(FileUtil.readFileData(path, fileName));
				HashSet<String> eventSet = new HashSet<>();
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("E")) {
						eventSet.add(content.get(i)[1]);
					}
				}
				result += eventSet.size();
			}
		}
		
		return result;
	}

	@Override
	public int getPromedEntityNum() {
		String path = FilePath.path.promedPath;
		ArrayList<String> annFileList = FileUtil.getAnnFileList(path);
		
		int result = 0;
		for(String fileName : annFileList) {
			if(!fileName.contains("1488") && !fileName.contains("1501") ) {
				//읽어온 데이터
				ArrayList<String[]> content = FileUtil.splitFileData(FileUtil.readFileData(path, fileName));
				
				for(int i = 0; i<content.size(); i++) {
					if(content.get(i)[0].substring(0, 1).equals("T")) {
						result++;
					}
				}			
			}
		}
		
		return result;
	}

}
