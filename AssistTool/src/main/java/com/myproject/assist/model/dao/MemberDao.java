package com.myproject.assist.model.dao;

import java.util.List;

import com.myproject.assist.model.dto.Member;

public interface MemberDao {
	
	void insertMember(Member member);
	
	Member selectMemberById(String id);
	
	Member selectMemberByIdAndPasswd(String id, String password);
	
	List<Member> selectMemberList();
	
	void deleteMember(String id);
	
	void updateUserType(String id, String userType);
	
}