package com.myproject.assist.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	 * @Method   : getFileList
	 * @작성일     : 2017. 11. 13
	 * @작성자     : jeehyun
	 * @explain : 해당 경로에서 파일 목록을 전 읽어온다.
	 * @param : String path
	 * @return : File[] fileList
	 */
	public static File[] getFileList(String path) {
		
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		
		return fileList;
	}
	
	/**
	 * @Method   : getTextFileList
	 * @작성일     : 2017. 11. 13
	 * @작성자     : jeehyun
	 * @explain : 해당 경로에서 txt파일만 읽어온다.
	 * @param : String path
	 * @return : ArrayList<String> txtFileList
	 */
	public static ArrayList<String> getTextFileList(String path) {
		ArrayList<String> txtFileList = new ArrayList<>();
		
		File dir = new File(path);
		String[] fileList = dir.list();
		
		for(String fileName : fileList) {
			if(fileName.contains(".txt")) {
				txtFileList.add(fileName);
			}
		}
		
		return txtFileList;
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
	 * @explain : 한줄씩 저장되있는 리스트를 받아서 스페이스, 탭으로 split
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
	 * @Method   : getTextString
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : text 파일을 모두 읽어 stringBuilder로 만든다.
	 * @param : String path, String fileName
	 * @return : StringBuilder sb
	 */
	public static StringBuilder getTextString(String path, String fileName) {
		BufferedReader br;
		String name = fileName.substring(0, fileName.length() - 3) + "txt";
		File file = new File(path, name);
		
		String lines;
		
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(file));
			while((lines = br.readLine()) != null) {
				sb.append(lines + "\n");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return sb;
	}
	
	public static String[] getTextStringArray(String path, String fileName) {
		BufferedReader br;
		String name = fileName.substring(0, fileName.length() - 3) + "txt";
		File file = new File(path, name);
		
		String lines;
		
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(file));
			while((lines = br.readLine()) != null) {
				sb.append(lines + "\n");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return sb;
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
	 * @Method   : getLineContent
	 * @작성일     : 2017. 11. 13
	 * @작성자     : jeehyun
	 * @explain : 태깅된 한 줄의 데이터를 이용해, 해당 문장을 찾아온다.
	 * @param : String path, String fileName, String[] content
	 * @return : String line
	 */
	public static String getLineContent(String path, String fileName, String[] content) {
		BufferedReader br;
		String name = fileName.substring(0, fileName.length() - 3) + "txt";
		File file = new File(path, name);
		
		String lines;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(file));
			while((lines = br.readLine()) != null) {
				sb.append(lines + "\n");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		String[] end = new String[]{};
		if(content[3].contains(";")) {
			end = content[3].split(";");
			return sb.substring(Integer.parseInt(content[2]), Integer.parseInt(end[0]));
		} else {
			return sb.substring(Integer.parseInt(content[2]), Integer.parseInt(content[3]));
		}
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
	 * @Method   : getContentLineByEntityNo
	 * @작성일     : 2017. 11. 8
	 * @작성자     : jeehyun
	 * @explain : entityNo를 이용해 event에 속해있는 엔터티들의 구조를 가져온다.
	 * @param :String entityNo, ArrayList<String[]> content
	 * @return :String[] result
	 */
	public static String[] getContentLineByEntityNo(String entityNo, ArrayList<String[]> content) {
		String[] result = new String[] {};
		for(int i = 0; i < content.size(); i++) {
			if(content.get(i)[0].equals(entityNo)) {
				result = content.get(i);
			}
		}
		return result;
	}
	
	/**
	 * @Method   : getEventWord
	 * @작성일     : 2017. 11. 13
	 * @작성자     : jeehyun
	 * @explain : event에 해당하는 엔터티 번호를 이용하여 해당하는 단어를 찾는다.
	 * @param : String entityNo, ArrayList<String[]> content
	 * @return : String word
	 */
	public static String getEventWord(String entityNo, ArrayList<String[]> content) {
		String word = "";
		for(int i =0; i<content.size(); i++) {
			if(content.get(i)[0].equals(entityNo)) {
				word = getWord(content.get(i));
			}
		}
		return word;
	}
	
	/**
	 * 
	 * @Method   : getFileTextAtOnce
	 * @작성일     : 2017. 9. 19. 
	 * @작성자     : choikino
	 * @explain :line by line 아니고 파일 내용 한번에 읽기
	 * @param :String path, String fileName
	 * @return :String fileText
	 */
	public String getFileTextAtOnce(String path, String fileName) {
		String fileText = "";
		try {
			File file = new File(path, fileName);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			fileText = new String(data, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fileText;
	}

	/**
	 * 
	 * @Method   : writeAnnFile
	 * @작성일     : 2017. 9. 20. 
	 * @작성자     : choikino
	 * @explain : 파일명까지 포함된 최종경로와 쓸 데이터를 인자로 받아 새로운 ann 파일을 생성한다.
	 * @param :String fileFullPath, String writeStr
	 * @return :
	 */
	public void writeAnnFile(String path, String fileName, String writeStr) {
        BufferedWriter bw = null;
        try{
        		File dir = new File(path);
        		if(!dir.exists()) {
        			dir.mkdirs();
        		}
        		String fileFullPath = path + "/" + fileName;
            bw = new BufferedWriter(new FileWriter(fileFullPath));
            bw.write(writeStr);
            bw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bw != null) {
            		try {
            			bw.close(); 
            		} catch (Exception e) {
            			e.printStackTrace();
            		}
            }
        }
	}

}
