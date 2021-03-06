package com.ssafy.safefood.service;

import com.ssafy.safefood.vo.Member;

public interface MemberService {
	void registerMember(Member member) throws Exception;
	void updateMember(Member member) throws Exception;
	void deleteMember(String id) throws Exception;
	Member findMemberById(Member member) throws Exception;
	Member findPassById(Member member) throws Exception;
	Object idcheck(String id) throws Exception;
	Member login(Member member) throws Exception;
}
