package com.myproject.assist.model.service;

import java.util.List;

import com.myproject.assist.model.dto.Member;

public interface MemberService {
	
	void registerMember(Member member);
	
	Member getMemberById(String id);
	
	Member getMemberByIdAndPassword(String id, String password);
	
	List<Member> getMemberList();
	
	void deleteMember(String id);
	
	void changeUserType(String id, String userType);
	
	List<Member> getWorkerList();
}
