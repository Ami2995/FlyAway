package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.bean.UserBean;
import com.java.helper.DBConnection;

public class UserDAO {

	public int signupUser(UserBean user) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}

		String sql = "insert into user values(?,?,?,?)";
		PreparedStatement ps = null;
		int row = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getContact());
			ps.setString(4, user.getPassword());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public boolean validateUser(UserBean user) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("connection established in display code");
		} else {
			System.out.println("check the connection");
		}
		String sql = "select * from user where email=? and password=?";
		boolean status = false; 
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());

			ResultSet rs = pst.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
