package com.devtory.jspboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class TestMySql {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC", "jsp", "jsp#1142");
			
			System.out.println("데이터베이스 연결 성공");
			
			String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";        // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "jsp";                                                    // 사용자 계정
			String pw = "jsp#1142";                                                // 사용자 계정의 패스워드

			conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "insert into member1 values(?,?,?,?)";        // sql 쿼리
			pstmt = conn.prepareStatement(sql);                          // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1,"test");
			pstmt.setString(2,"passwd");
			pstmt.setString(3,"김철수");
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));    // 현재 날짜와 시간
			pstmt.executeUpdate();                                        // 쿼리를 실행한다.

			System.out.println("member 테이블에 새로운 레코드를 추가했습니다.");        // 성공시 메시지 출력

			
		} catch (Exception e) {
			System.out.println("시스템 오류"+e);
		}

	}

}
