package com.service.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.spring.domain.Member;

@Service
public class MemberServiceImpl {
	
	@Autowired
	MemberDAOImpl memberDAOImpl;
	
	@PostMapping("/register")
	public void registerMember(Member member)throws Exception{
		memberDAOImpl.registerMember(member);
	}
	
	public void deleteMember(String id)throws Exception{
		memberDAOImpl.deleteMember(id);
	}
	
	public void updateMember(Member member)throws Exception{
		memberDAOImpl.updateMember(member);
	}
	
	public List<Member> showAllMember()throws Exception{
		return memberDAOImpl.showAllMember();
	}
	
	public Member getMember(String id)throws Exception{
		return memberDAOImpl.getMember(id);
	}
	
	public String idExist(String id)throws Exception{
		return memberDAOImpl.idExist(id);
	}
	
	public Member login(Member member)throws Exception{
		return memberDAOImpl.login(member);
	}
}
