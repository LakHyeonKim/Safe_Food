package com.ssafy.safefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.MemberDAO;
import com.ssafy.safefood.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void registerMember(Member member) throws Exception {
		memberDAO.registerMember(member);
	}
	
	@Override
	public void updateMember(Member member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberDAO.deleteMember(id);
	}

	@Override
	public Member findMemberById(Member member) throws Exception {
		return memberDAO.findMemberById(member);
	}

	@Override
	public Object idcheck(String id) throws Exception {
		return memberDAO.idcheck(id);
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDAO.login(member);
	}

	@Override
	public Member findPassById(Member member) throws Exception {
		return memberDAO.findPassById(member);
	}

}
