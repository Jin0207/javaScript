package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;

public class BookDAO {
	
	//도서명과 출판사를 매개변수로 전달받아 해당도서의 가격을 반환하는 메소드
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
