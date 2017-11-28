package com.myproject.assist.model.mapper;

import java.util.HashMap;
import java.util.List;

import com.myproject.assist.model.dto.Member;

//com.mvcdemoweb.model.mapper.MemberMapper 파일에 대응하는 인터페이스
public interface WorkMapper {
	
	void insertMember(Member  member);
	
	Member selectMemberById(String id);
	
	Member selectMemberByIdAndPassword(HashMap<String, Object> params);
	
	List<Member> selectMembers();
	
	void deleteMember(String id);
	
	void updateMemberUserType(HashMap<String, String> params);
	
}
