package com.smhrd.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	// 초기화 불럭: static{} -> 프로그램 시작과 동시에 무조건 셋팅되어 시작되는구조!.
	static {
		try {
			String resource = "com/smhrd/db/Mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 초기화 단계에서 생성도니 sqlSessionFactory 결과를 반환하는 메소드 생성!.

	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;  
		// SqlSession 관래 해주는 기능 sqlSessionFactory에 다있음.DAO기능 이라든지.
		// 공장 만들었으면 이제 써먹어야 하니까.
	}

}
