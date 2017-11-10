package com.myproject.assist.model.service;

import java.util.ArrayList;

public interface ConstructureService {
	
	ArrayList<ArrayList<String>> CheckConstructureOfLack(String folderName, String nextPath);
	
	ArrayList<ArrayList<String>> CheckConstructureOfMismatch(String folderName, String nextPath);

}
