package com.myproject.assist.model.service;

import java.util.ArrayList;

public interface ConcordanceService {
	
	ArrayList<ArrayList<String>> textConcordance(String text);
	
	ArrayList<ArrayList<String>> allEntityConcordance();
	
	ArrayList<ArrayList<String>> concordanceWithEntityType(String type);
	
	ArrayList<ArrayList<String>> concordanceWithWord(String text);
	
	ArrayList<ArrayList<String>> EntityConcordance(String type, String text);
	
	ArrayList<ArrayList<String>> allEventConcordance();
	
	ArrayList<ArrayList<String>> concordanceWithEventType(String type);
	
	ArrayList<ArrayList<String>> concordanceWithEventWord(String text);
	
	ArrayList<ArrayList<String>> EventConcordance(String type, String text);
	
	
}
