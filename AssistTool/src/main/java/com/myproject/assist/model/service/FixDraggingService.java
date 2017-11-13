package com.myproject.assist.model.service;

import java.util.ArrayList;
import java.util.Map;

public interface FixDraggingService {
	
	Map<String, Object> checkFixTypeOfErrors(String folderName, String nextPath);

	String mkFixedAnnFiles(String nextPath, String folderName, Map<String, ArrayList<String>> writeDataListPerDir);

}
