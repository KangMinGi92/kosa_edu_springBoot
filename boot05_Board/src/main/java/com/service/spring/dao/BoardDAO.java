package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Board;

@Repository
public class BoardDAO {
	
	public static final String NS = "ns.sql.BoardMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	public int write(Board vo)throws Exception{
		return sqlSession.insert(NS+"write",vo);
	}
	
	public String selectByNoForDate(int no)throws Exception{
		return sqlSession.selectOne(NS+"selectByNoForDate",no);
	}
	
	public List<Board> getBoardListO()throws Exception{
		return sqlSession.selectList(NS+"getBoardList");
	}
	
	public Board showContent(int no)throws Exception{
		return sqlSession.selectOne(NS+"showContent",no);
	}
	
	public void deleteBoard(int no)throws Exception{
		sqlSession.delete(NS+"deleteBoard",no);
	}
	
	public void updateBoard(Board vo)throws Exception{
		sqlSession.update(NS+"updateBoard",vo);
	}
	
	public void updateCount(int no)throws Exception{
		sqlSession.update(NS+"updateCount",no);
	}
}
