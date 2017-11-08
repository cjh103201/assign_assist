package com.myproject.assist.model.service;

public interface CountingService {
	
	//total
	int getTotalDocNum();
	
	int getTotalNoDocNum();
	
	int getTotalEventNum();
	
	int getTotalDistinctEventNum();
	
	int getTotalEntityNum();
	
	//news
	int getNewsDocNum();
	
	int getNewsNoDocNum();
	
	int getNewsEventNum();
	
	int getNewsDistinctEventNum();
	
	int getNewsEntityNum();

	//Promed
	int getPromedDocNum();
	
	int getPromedNoDocNum();
	
	int getPromedEventNum();
	
	int getPromedDistinctEventNum();
	
	int getPromedEntityNum();

}
