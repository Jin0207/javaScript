package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;

public class BookDAO {
	
	//������� ���ǻ縦 �Ű������� ���޹޾� �ش絵���� ������ ��ȯ�ϴ� �޼ҵ�
	public int getPrice(String bookName, String publisher) {
		int price = 0;
		String sql = "select price from book where bookname=? and publisher=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			pstmt.setString(2, publisher);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				price = rs.getInt(1);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			ConnectionProvider.close(rs, pstmt, conn);
		}
		
		return price;
	}
}
