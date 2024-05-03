package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MessageDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 메세지 보내기 기능.
	public int sendMessage(MessageaDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 세션 열어줌.

		int result = sqlSession.insert("sendMessage", dto); // 다양한 쿼리문을 사용할수 있음.

		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return result;
	}

	// 메세지 확인을 위한 기능.
	public ArrayList<MessageaDTO> showMessage(String email) {
		// 사용할 ArrayList 생성!.
		ArrayList<MessageaDTO> m_list = new ArrayList<MessageaDTO>();
		// 1. sql대여
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 세션 열어줌.

		// 2.sql실행
		m_list = (ArrayList) sqlSession.selectList("showMessage", email); // list르 반환함.

		// 3.결과처리
		// 4.sql반납
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return m_list;
	}

	// 딜리티 메서드
	public int deleteMessage(int num) {
		// 1. sql대여
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 세션 열어줌.
		// 2.sql실행
		int cnt = sqlSession.delete("deleteMessage", num);	
		
		// 4.sql반납
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return cnt;
	}
	
	// 딜리트 all메서드 기능
	public int deleteAllMessage(String email) {
		// 1. sql대여
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 세션 열어줌.
		// 2.sql실행
		int cnt = sqlSession.delete("deleteAllMessage", email);
		
		// 4.sql반납
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return cnt;
	}
	

}
