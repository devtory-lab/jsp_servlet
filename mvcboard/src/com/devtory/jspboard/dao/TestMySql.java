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
			
			System.out.println("�����ͺ��̽� ���� ����");
			
			String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���
			String id = "jsp";                                                    // ����� ����
			String pw = "jsp#1142";                                                // ����� ������ �н�����

			conn=DriverManager.getConnection(url,id,pw);              // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

			String sql = "insert into member1 values(?,?,?,?)";        // sql ����
			pstmt = conn.prepareStatement(sql);                          // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt.setString(1,"test");
			pstmt.setString(2,"passwd");
			pstmt.setString(3,"��ö��");
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));    // ���� ��¥�� �ð�
			pstmt.executeUpdate();                                        // ������ �����Ѵ�.

			System.out.println("member ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�.");        // ������ �޽��� ���

			
		} catch (Exception e) {
			System.out.println("�ý��� ����"+e);
		}

	}

}
