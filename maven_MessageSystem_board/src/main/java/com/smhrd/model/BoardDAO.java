package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	// 게시글 작성
	public int writeBoard(Board vo) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.database.BoardMapper.writeBoard", vo);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	// 게시글 전체 조회
	public List<Board> allBoard(){
		List<Board> boards = null;
		try {
			boards = sqlSession.selectList("com.smhrd.database.BoardMapper.allBoard");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return boards;
	}
	
	
	// 게시글 상세 조회
	public Board detailBoard(int num) {
		Board board = null;
		try {
			board 
			= sqlSession.selectOne("com.smhrd.database.BoardMapper.detailBoard", num);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return board;
	}
	
	
	
	
	
	
	
}
