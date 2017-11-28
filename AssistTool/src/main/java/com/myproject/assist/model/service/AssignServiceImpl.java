package com.myproject.assist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myproject.assist.model.dao.AssignDao;
import com.myproject.assist.model.dto.Assign;

@Service("assignService")
public class AssignServiceImpl implements AssignService {

	@Autowired
	@Qualifier("assignDao")
	private AssignDao dao;
	
	@Override
	public void registerAssign(Assign assign) {
		dao.insertAssign(assign);
	}

	@Override
	public List<Assign> getAssignList() {
		return dao.selectAssign();
	}

	@Override
	public List<Assign> getAssignListByID(String id) {
		return dao.selectAssignById(id);
	}

}
