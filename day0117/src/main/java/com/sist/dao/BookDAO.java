package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	
	public int insert(BookVO b) {
		int re = -1;
		String sql = "insert into book values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getBookName());
			pstmt.setString(3, b.getPulisher());
			pstmt.setInt(4, b.getPrice());
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(pstmt, conn);
		}
		return re;
	}
}
