package com.myproject.assist.model.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.myproject.assist.model.dto.Member;
import com.myproject.assist.model.mapper.MemberMapper;

@Repository(value = "memberDao")
public class MysqlMemberDao implements MemberDao {
	
	@Autowired
	@Qualifier("memberMapper")
	private MemberMapper memberMapper;	

	@Override
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}

	@Override
	public Member selectMemberById(String id) {
		Member member = memberMapper.selectMemberById(id);
		return member;
	}

	@Override
	public Member selectMemberByIdAndPasswd(String id, String password) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("password", password);
		
		Member member = memberMapper.selectMemberByIdAndPassword(params);
		return member;
	}

	@Override
	public List<Member> selectMemberList() {
		List<Member> members = memberMapper.selectMembers();
		return members;
	}

	@Override
	public void deleteMember(String id) {
		memberMapper.deleteMember(id);
	}

	@Override
	public void updateUserType(String id, String userType) {
		HashMap<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("userType", userType);
		
		memberMapper.updateMemberUserType(params);
	}

}









