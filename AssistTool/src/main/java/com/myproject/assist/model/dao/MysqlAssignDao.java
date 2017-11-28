package com.myproject.assist.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.myproject.assist.model.dto.Assign;
import com.myproject.assist.model.mapper.AssignMapper;

@Repository(value = "assignDao")
public class MysqlAssignDao implements AssignDao {
	
	@Autowired
	@Qualifier("assignMapper")
	private AssignMapper assignMapper;

	@Override
	public void insertAssign(Assign assign) {
		assignMapper.insertAssign(assign);
	}

	@Override
	public List<Assign> selectAssign() {
		return assignMapper.selectAssign();
	}

	@Override
	public List<Assign> selectAssignById(String id) {
		return assignMapper.selectAssignById(id);
	}	

	
}









