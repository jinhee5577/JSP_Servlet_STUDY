package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MemberDAO {

	// 세션을 생성해 줄 수 있는 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	// connection, close, sql문 실행...
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	// 회원가입
	public int joinMember(Member vo) {
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("com.smhrd.database.MemberMapper.joinMember", vo);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	// 로그인
	public Member loginMember(Member vo) {
		Member loginMember = null;
		try {
			loginMember = sqlSession.selectOne("com.smhrd.database.MemberMapper.loginMember", vo);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return loginMember;
	}
	
	// 중복확인
	public boolean emailCheck(String inputE) {
		boolean checkE = false;
		try {
			checkE = sqlSession.selectOne("com.smhrd.database.MemberMapper.emailCheck", inputE);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		
		return checkE; // true or false
	}

	public int updateMember(Member updateMember) {
		int cnt = 0;
			try {
				cnt = sqlSession.update("com.smhrd.database.MemberMapper.updateMember", updateMember);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				sqlSession.close();
			}
		return cnt;
	}
	
	public List<Member> allMember() {
		List<Member> members = null;
		try {
			members 
			= sqlSession.selectList("com.smhrd.database.MemberMapper.allMember");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return members;
	}

	public int deleteMember(String email) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.smhrd.database.MemberMapper.deleteMember", email);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	
	
	
	
	
	
	
}
