package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;
import com.sist.vo.OrderBookInfo;

public class BookDAO {
	
	//고객번호를 매개변수로 전달받아 해당 고객이 주문한 도서 번호, 도서명, 출판사명, 구매일, 도서가격, 구매가격을 반환하는 메소드
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
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return list;
	}
	
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
	
	// 도서번호를 매개변수로 전달받아 도서정보(도서명, 출판사,가격)를 반환하는 메소드
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
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(rs, pstmt, conn);
		}
		return list;
		
	}
	
	//출판사명을 매개변수로 전달받아 해당 출판사에서 출간하는 모든 도서목록을 반환하는 메소드
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
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(rs, pstmt, conn);
		}
		
		return list;
	}
}
