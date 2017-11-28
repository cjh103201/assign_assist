package com.myproject.assist.model.mapper;

import java.util.List;

import com.myproject.assist.model.dto.Assign;

//com.mvcdemoweb.model.mapper.MemberMapper 파일에 대응하는 인터페이스
public interface AssignMapper {
	
	void insertAssign(Assign assign);
	
	List<Assign> selectAssign();
	
	List<Assign> selectAssignById(String id);
	
}
