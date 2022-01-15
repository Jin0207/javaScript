package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;
import com.sist.vo.OrderBookInfo;

public class BookDAO {
	
	//����ȣ�� �Ű������� ���޹޾� �ش� ���� �ֹ��� ���� ��ȣ, ������, ���ǻ��, ������, ��������, ���Ű����� ��ȯ�ϴ� �޼ҵ�
	public ArrayList<OrderBookInfo> listOrderBook(int custid){
		ArrayList<OrderBookInfo> list = new ArrayList<OrderBookInfo>();
		String sql= "select b.bookid, bookname, publisher, orderdate, price, saleprice from book b, customer c, orders o where b.bookid = o.bookid and c.custid = o.custid and c.custid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new OrderBookInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6)));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return list;
	}
	
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
	
	// ������ȣ�� �Ű������� ���޹޾� ��������(������, ���ǻ�,����)�� ��ȯ�ϴ� �޼ҵ�
	public BookVO listBookInfo(int no){
		BookVO list = new BookVO();
		String sql = "select bookname, publisher, price from book where bookid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.setBookName(rs.getString(1));
				list.setPulisher(rs.getString(2));
				list.setPrice(rs.getInt(3));
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(rs, pstmt, conn);
		}
		return list;
		
	}
	
	//���ǻ���� �Ű������� ���޹޾� �ش� ���ǻ翡�� �Ⱓ�ϴ� ��� ��������� ��ȯ�ϴ� �޼ҵ�
	public ArrayList<BookVO> listBookName(String publisher){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select bookname, price from book where publisher=?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookVO v = new BookVO();
				v.setBookName(rs.getString(1));
				v.setPrice(rs.getInt(2));
				list.add(v);
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(rs, pstmt, conn);
		}
		
		return list;
	}
}
