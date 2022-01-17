package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.CustomerVO;

public class CustomerDAO {
	
	public int insert(CustomerVO c) {
		int re = -1;
		String sql = "insert into customer values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getCustid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getAddress());
			pstmt.setString(4, c.getPhone());
			
			re = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}finally {
			ConnectionProvider.close(pstmt, conn);
		}
		return re;
	}
	
	public int update(CustomerVO c) {
		int re = -1;
		String sql = "update customer set name=?,address=?,phone=? where custid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			pstmt.setInt(4, c.getCustid());
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}finally {
			ConnectionProvider.close(pstmt, conn);
		}
		
		return re;
	}
	
	public int delete(int custid) {
		int re = -1;
		String sql = "delete from customer where custid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}finally {
			ConnectionProvider.close(pstmt, conn);
		}
		return re;
	}
	
	
	//고객정보를 모두 출력하는 메소드
	public ArrayList<CustomerVO> listCustomer(){
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		String sql = "select * from customer order by custid";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CustomerVO vo = new CustomerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(rs, stmt, conn);
		}
		
		
		return list;
		
	}
	
	
}
