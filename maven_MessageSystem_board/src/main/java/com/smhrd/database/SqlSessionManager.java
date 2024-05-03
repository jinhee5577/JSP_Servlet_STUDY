package com.smhrd.database;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	// 4. SqlSessionManager 만들기
	//   SqlSessionFactory를 관리하는 class
	//   SqlSession == Connection 
	//   SqlSessionFactory == Connection객체를 여러개 가지고 있는 공장
	//   데이터베이스를 *미리* 연결하는 동작(Connection Pool : CP)
	//   why? db연결하는 부분이 성능이 가장 떨어지는 부분이라서 성능 향상을 위해
	//   mybatis는 성능 향상을 위해 connection객체를 
	//   미리 만들어서 빌려주고 반납하는 형식으로 진행
	
	// static 블록 : 객체를 호출할 때 무조건 실행되는 부분
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			// mybatis 환경설정 파일 경로 
			String resource = "com/smhrd/database/mybatis-config.xml";
			
			// xml파일을 읽어내기 위해 inputStream 여는 것!
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// SqlSessionFactory : connection객체가 여러개인 Connection Pool
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
		

}
