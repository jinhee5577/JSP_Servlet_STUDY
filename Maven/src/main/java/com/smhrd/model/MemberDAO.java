package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {
	// DAO는 DB연결만 하고 싶음.
	// sqlSessionFactory 불러오기: DB관련 기능을 사용할수 있는 세션을 만들어주는 공장.
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// db관련(DAO가 하던)각 기능을 수행하는 세션을 저장하는 변수.
	SqlSession sqlSession;
	// db와 연결 하기 위한 세션.

	// 기존 DAO처럼 각 SQL문을 실행할 메서드 만들기.
	// 각 SQL문의 문열고 문닫고 하던 행동을 딱 한번씩만 문열고 문닫고 해주면 여기서DAO파일에서 해야할일 끝이다!!! 완전 간단!!!
	
	// 로그인 기능의 메서드.
	public MemberDTO login(MemberDTO member) { 
		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)
		sqlSession = sqlSessionFactory.openSession(true);
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.

		MemberDTO loginMember = null;

		// "MemberSQL.LoginSelect" mapper의 위치이다.
		
		try { // 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
			loginMember = sqlSession.selectOne("MemberSQL.LoginSelect", member); // 다양한 쿼리문을 사용할수 있음.
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			sqlSession.close(); // 세션문 닫아준다.
		}
		
		return loginMember;

	}
	
	
	// join 기능 메서드
	public int join(MemberDTO member) { 
		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)
		sqlSession = sqlSessionFactory.openSession(true);
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.
		
		int row = 0;		
		
		// "MemberSQL.JoinMember" mapper의 위치이다.
		try { // 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		   row = sqlSession.insert("MemberSQL.JoinMember", member); // 다양한 쿼리문을 사용할수 있음.	
		   
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			sqlSession.close(); // 세션문 닫아준다.
		}
		
		return row;
	}
	
		
	// logout 기능 메서드
	public int logout(MemberDTO member) {
		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)
		sqlSession = sqlSessionFactory.openSession(true);
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.
		
		int row = 0;
		
		// "MemberSQL.JoinMember" mapper의 위치이다.
		try { // 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
			row = sqlSession.insert("MemberSQL.JoinMember", member); // 다양한 쿼리문을 사용할수 있음.	
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			sqlSession.close(); // 세션문 닫아준다.
		}
		
		return row;
	}
	
	

}
