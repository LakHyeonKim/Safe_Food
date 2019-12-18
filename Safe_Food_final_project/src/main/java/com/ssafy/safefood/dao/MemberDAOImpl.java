package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String ns = "userMapper.";
	
	@Override
	public void registerMember(Member member) throws Exception {
		sqlSession.insert(ns+"registerMember", member);
	}
	
	@Override
	public void updateMember(Member member) throws Exception {
		sqlSession.update(ns+"updateMember", member);
	}
	
	@Override
	public void deleteMember(String id) throws Exception {
		sqlSession.delete(ns+"deleteMember", id);
	}
	
	@Override
	public Member findMemberById(Member member) throws Exception {
		return sqlSession.selectOne(ns+"findMemberById", member);
	}
	
	@Override
	public Object idcheck(String id) throws Exception {
		return sqlSession.selectOne(ns+"idcheck", id);
	}
	
	@Override
	public Member login(Member member) throws Exception {
		return sqlSession.selectOne(ns+"login", member);
	}

	@Override
	public Member findPassById(Member member) throws Exception {
		return sqlSession.selectOne(ns+"findPassById", member);
	}
}
