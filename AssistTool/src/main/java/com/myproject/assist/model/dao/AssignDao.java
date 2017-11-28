package com.myproject.assist.model.dao;

import java.util.List;

import com.myproject.assist.model.dto.Assign;

public interface AssignDao {
	
	void insertAssign(Assign assign);
	
	List<Assign> selectAssign();
	
	List<Assign> selectAssignById(String id);
}