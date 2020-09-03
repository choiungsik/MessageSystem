package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class messageDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	messageDTO dto = null;
	ArrayList<messageDTO> list = null;

	public void conn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public int send(messageDTO dto) {
		conn();
		
		String sql = "insert into web_message VALUES(MESSAGE_NUM_SEQ.nextval, ?, ?, ?, sysdate)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSend());
			psmt.setString(2, dto.getReceive());
			psmt.setString(3, dto.getMessage());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	public ArrayList<messageDTO> select(String receive) {
		list = new ArrayList<messageDTO>();
		
		conn();
		
		String sql = "select * from web_message where receive = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, receive);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt(1);
				String send = rs.getString("SEND");
				String re = rs.getString("RECEIVE");
				String me = rs.getString("MESSAGE");
				String date = rs.getString(5);
				dto = new messageDTO(num, send, re, me, date);
				
				list.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int delete(String email) {
		conn();
		
		String sql = "delete from web_message where receive = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	public int deleteOne(String num) {
		conn();
		
		String sql = "delete from web_message where message_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
}
