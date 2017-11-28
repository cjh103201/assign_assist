package com.myproject.assist.model.service;

import java.util.List;

import com.myproject.assist.model.dto.Assign;

public interface AssignService {
	
	void registerAssign(Assign assign);
	
	List<Assign> getAssignList();
	
	List<Assign> getAssignListByID(String id);
	
}
