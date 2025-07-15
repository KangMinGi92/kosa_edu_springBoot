package com.service.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Member;

@Repository
public class MemberDAOImpl {
	private static final String NS = "MemberMapper.";
	
	@Autowired
	SqlSession sqlSession;
	
	public void registerMember(Member member)throws Exception{
		sqlSession.insert(NS+"registerMember",member);
	}
	
	public void deleteMember(String id)throws Exception{
		sqlSession.delete(NS+"deleteMember",id);
	}
	
	public void updateMember(Member member)throws Exception{
		sqlSession.update(NS+"updateMember",member);
	}
	
	public List<Member> showAllMember()throws Exception{
		return sqlSession.selectList(NS+"showAllMember");
	}
	
	public Member getMember(String id)throws Exception{
		return sqlSession.selectOne(NS+"getMember",id);
	}
	
	public String idExist(String id)throws Exception{
		return sqlSession.selectOne(NS+"idExist",id);
	}
	
	public Member login(Member member)throws Exception{
		return sqlSession.selectOne(NS+"login",member);
	}
}
