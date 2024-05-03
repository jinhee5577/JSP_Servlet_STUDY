package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class BoardDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	
	//게시글 작성에 대한 메소드
	public int upload(BoardDTO dto) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 세션 열어줌.
		int result = sqlSession.insert("upload", dto); // 다양한 쿼리문을 사용할수 있음.
		
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return result;	
	}	
	
	// 나의 전송된 모든 게시글 보기
	public ArrayList<BoardDTO> showBoard(String writer) {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		SqlSession sqlSession = sqlSessionFactory.openSession(true);  //세션 열어줌.
		ArrayList<BoardDTO> allposts = new ArrayList<BoardDTO>();
		
		try {
			allposts = (ArrayList) sqlSession.selectList("showBoard", writer); // 리턴이 selectList => List 형태로 뱉어줌.
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}		

		return allposts;
	}
	
	// 선생님 전송방법
	public ArrayList<BoardDTO> showBoard2() {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		SqlSession sqlSession = sqlSessionFactory.openSession(true);  //세션 열어줌.
		ArrayList<BoardDTO> allposts = new ArrayList<BoardDTO>();
		
		try {
			allposts = (ArrayList) sqlSession.selectList("showBoard2"); // 리턴이 selectList => List 형태로 뱉어줌.
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}		

		return allposts;
	}
	
	
	public BoardDTO showDetail(int num) {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		SqlSession sqlSession = sqlSessionFactory.openSession(true);  //세션 열어줌.
		
	    BoardDTO dto  =  sqlSession.selectOne("showDetail",num); // 리턴이 selectList => List 형태로 뱉어줌.
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		
		return dto;
	}
	
	
	
	
	
	

}
