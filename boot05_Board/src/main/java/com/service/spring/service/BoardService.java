package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	
	public int write(Board vo)throws Exception{
		System.out.println("Before vo :: "+vo);//no가 없을것이다.
		int row=boardDAO.write(vo);
		
		String date=boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		
		System.out.println("After vo :: "+vo);//no가 있을것이다.
		return row;
	}
	
	public String selectByNoForDate(int no)throws Exception{
		return boardDAO.selectByNoForDate(no);
	}
	
	public List<Board> getBoardList()throws Exception{
		return boardDAO.getBoardListO();
	}
	
	public Board showContent(int no)throws Exception{
		return boardDAO.showContent(no);
	}
	
	public void deleteBoard(int no)throws Exception{
		boardDAO.deleteBoard(no);
	}
	
	public void updateBoard(Board vo)throws Exception{
		boardDAO.updateBoard(vo);
	}
	
	public void updateCount(int no)throws Exception{
		boardDAO.updateCount(no);
	}
}
