package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {
	// 데이터베이스에 연결하여 쓸수 잇는 기능 작업!.
	// DAO는 DB연결만 하고 싶음.
	// sqlSessionFactory 불러오기: DB관련 기능을 사용할수 있는 세션을 만들어주는 공장.
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);  //세션 열어줌.
	// db관련(DAO가 하던)각 기능을 수행하는 세션을 저장하는 변수.
	// db와 연결 하기 위한 세션.

	// 기존 DAO처럼 각 SQL문을 실행할 메서드 만들기.
	// 각 SQL문의 문열고 문닫고 하던 행동을 딱 한번씩만 문열고 문닫고 해주면 여기서DAO파일에서 해야할일 끝이다!!! 완전 간단!!!

	// 회원가입 메소드 생성!.
	public int join(MemberDTO dto) {
		// 1. sqlSession 빌려오기!. <-- db에 접근해서 확인해야하니. sqlSession빌려오는거임.

		// 2. sql문장 전달!.
		int result = sqlSession.insert("join", dto);

		// 3. 결과처리!.
		if (result > 0) {
			System.out.print("회원가입 성공!.");
		}

		// 4. sqlSession 반납!.
		sqlSession.close(); // 세션문 닫아준다.

		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)

		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.

		return result;

	}

	// login 기능 메서드
	public MemberDTO login(MemberDTO dto) {
		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.

		MemberDTO loginMember = null;
		// "MemberSQL.JoinMember" mapper의 위치이다.
		try { // 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
				// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
			loginMember = sqlSession.selectOne("com.smhrd.db.MemberMapper.login", dto); // 다양한 쿼리문을 사용할수 있음.

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}

		return loginMember;
	}

	
	// 회원정보 업데이트 메서드
	public int updateMember(MemberDTO updateMember) {
		// openSession(auto commit 기능을 자동으로 할것인냐? 설정.)
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// sqlSession DB와 관련된 기능을 사용할수 있는 세션.
		// 공장 만들었으면 이제 써먹어야 하니까.
		// sqlSession에서 어떤 Mapper의 내용을 가져온다. 쓸건지 연결해줌.

		int row = 0;
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		row = sqlSession.update("updateMember", updateMember); // 다양한 쿼리문을 사용할수 있음.
		sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.

		return row;
	}
	
	//전체 회원조회 메서드
	public List<MemberDTO> allMember() {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		List<MemberDTO> members = null;
		
		try {
			members = sqlSession.selectList("allMembers"); // 리턴이 selectList => List 형태로 뱉어줌.
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}		

		return members;
	}
	
	// 회원정보 하나 삭제 메서드
	public int deleteMember(String eamil) {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		int row = 0;
		try {
			 row = sqlSession.delete("deleteMember", eamil); // 다양한 쿼리문을 사용할수 있음.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}
	
		return row;
	}
	
	
	// email중복 확인 기능.
	public boolean emailCheck(String inputE) {
		// "MemberSQL.JoinMember" mapper의 위치이다.
		// 쿼리를 실행 했을때 결과과 없을 수도 있으므로.
		// 전체 테이블중 이부분만 확인할수 있는 selectOne() 사용!.
		boolean checkE = false;
		try {
			checkE = sqlSession.selectOne("emailCheck", inputE); // 다양한 쿼리문을 사용할수 있음.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}
	
		return checkE;
	}
	
	
	// 메세지 보내기 기능.
	public boolean sendMessage(String inputE) {
		boolean checkE = false;
		
		try {
			checkE = sqlSession.selectOne("emailCheck", inputE); // 다양한 쿼리문을 사용할수 있음.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 빌려온 sqlSession반납해준다. 세션문 닫아준다.
		}
		
		return checkE;
	}
	
	
	
	

}
