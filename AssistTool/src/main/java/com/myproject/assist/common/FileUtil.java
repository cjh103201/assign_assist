package com.myproject.assist.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileUtil {
	
	/**
	 * @Method   : getFolderList
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 경로를 받아 그 경로 안에 존재하는 폴더명을 가져온다.
	 * @param :String path
	 * @return :ArrayList<String> folderList
	 */
	public static ArrayList<String> getFolderList(String path) {
		
		ArrayList<String> folderList = new ArrayList<>();
		
		File dir = new File(path);
		String[] list = dir.list();
		
		for(String l : list) {
			if(!l.contains(".")) {
				folderList.add(l);
			}
		}
		
		return folderList;
	}
	
	/**
	 * @Method   : getAnnFileList
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 해당 경로에서 ann파일만 읽어온다.
	 * @param : String path
	 * @return : ArrayList<String> annFileList
	 */
	public static ArrayList<String> getAnnFileList(String path) {
		ArrayList<String> annFileList = new ArrayList<>();
		
		File dir = new File(path);
		String[] fileList = dir.list();
		
		for(String fileName : fileList) {
			if(fileName.contains(".ann")) {
				annFileList.add(fileName);
			}
		}
		
		return annFileList;
	}
	
	/**
	 * @Method   : readFileData
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 경로와 파일명을 받아서 파일 안의 데이터를 읽는다.
	 * @param :String path, String fileName
	 * @return :ArrayList<String> contentLines 
	 */
	public static ArrayList<String> readFileData(String path, String fileName) {
		BufferedReader br;
		File file = new File(path, fileName);
		
		ArrayList<String> contentLines = new ArrayList<>();
		String lines;
		
		try {
			br = new BufferedReader(new FileReader(file));
			while((lines = br.readLine()) != null) {
				contentLines.add(lines);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return contentLines;
	}
	
	/**
	 * @Method   : splitFileData
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 한줄씩 저장되있는 리스트를 받아서 스페이스, 탭, 콜론으로 split
	 * @param :ArrayList<String> contentLines
	 * @return :ArrayList<String[]> content
	 */
	public static ArrayList<String[]> splitFileData(ArrayList<String> contentLines) {
		ArrayList<String[]> content = new ArrayList<>();
		
		for(String line : contentLines) {
			content.add(line.split(" |\t|:"));
		}
		return content;
	}
	
	/**
	 * @Method   : splitFileDataExceptEvent
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 한줄씩 저장되있는 리스트를 받아서 스페이스, 탭, 콜론으로 split
	 * @param :ArrayList<String> contentLines
	 * @return :ArrayList<String[]> content
	 */
	public static ArrayList<String[]> splitFileDataExceptEvent(ArrayList<String> contentLines) {
		ArrayList<String[]> content = new ArrayList<>();
		
		for(String line : contentLines) {
			content.add(line.split(" |\t"));
		}
		return content;
	}
	
	/**
	 * @Method   : getLine
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 태깅된 한 줄의 데이터를 이용해, 전체 텍스트에서 몇번째 줄에 위치하는지 찾는다.
	 * @param : String path, String fileName, String[] content
	 * @return : String line
	 */
	public static String getLine(String path, String fileName, String[] content) {
		BufferedReader br;
		String name = fileName.substring(0, fileName.length() - 3) + "txt";
		File file = new File(path, name);
		
		int line = 0;
		String lines;
		
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(file));
			while((lines = br.readLine()) != null) {
				sb.append(lines + "\n");
				line++;
				if(sb.length() >= Integer.parseInt(content[2])) {
					break;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return String.valueOf(line);
	}
	
	/**
	 * @Method   : getWord
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 태깅된 데이터의 하나의 줄에 있는 단어를 가져온다.
	 * @param :String[] content
	 * @return :String word
	 */
	public static String getWord(String[] content) {
		String word = "";
		for(int i = 4; i<content.length; i++) {
			word += content[i]+ " ";
		}
		return word;
	}
	
	/**
	 * @Method   : 
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 
	 * @param :
	 * @return :
	 */
	
	/**
	 * @Method   : 
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 
	 * @param :
	 * @return :
	 */
	
	/**
	 * @Method   : 
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : 
	 * @param :
	 * @return :
	 */

}
