package com.smhrd.model;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// SqlSessionManager => SqlSessionFactory를 불러오구, 만드는 클래스. : DB연결과 SQL실행에 대한 모든것을 가진객체.
	                  //  => sqlSession DB와 관련된 기능을 사용할수 있는 세션.  
	// SqlSessionFactory는 sqlSession을 만들어줌.	
	// 데이터 베이스와의 연결  + SQL실행데 대한 모든 것을 가진 객체 만들기.(제일 중요함.)
	public static SqlSessionFactory  sqlSessionFactory;

	// 클래스 초기화 불럭:  클래스가 처음 로딩될때 딱 한번만 수행.
   	static  {
		// 설정 정보 가져오기,
		String resource = "com/smhrd/model/mybatis-config.xml";  // 여러 설정 값들이 존재할수 있음.
		Reader reader;
		
		try {
			// 문자열 경로로 파일 읽는 역할.
			reader = Resources.getResourceAsReader(resource);
			// 읽은 정보 토대로 SqlSessionFactory 생성.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // reader 가 설정값.
			// 공장 설정다 해주고 공장 만들어줌.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;  
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// 공장 만들었으면 이제 써먹어야 하니까.
	}


}
