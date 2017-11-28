package com.myproject.assist.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myproject.assist.common.Util;
import com.myproject.assist.model.dao.MemberDao;
import com.myproject.assist.model.dto.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;

	@Override
	public void registerMember(Member member) {
		member.setPassword(Util.getHashedString(member.getPassword(), "SHA-256"));
		dao.insertMember(member);
	}
	
	@Override
	public Member getMemberById(String id) {
		return dao.selectMemberById(id);
	}

	@Override
	public Member getMemberByIdAndPassword(String id, String password) {
		return dao.selectMemberByIdAndPasswd(id, Util.getHashedString(password, "SHA-256"));
	}

	@Override
	public List<Member> getMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public void deleteMember(String id) {
		dao.deleteMember(id);
	}

	@Override
	public void changeUserType(String id, String userType) {
		dao.updateUserType(id, userType);
	}

	@Override
	public List<Member> getWorkerList() {
		return dao.selectMemberWorker();
	}
}
