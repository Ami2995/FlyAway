package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.bean.AdminLoginBean;
import com.java.helper.DBConnection;

public class AdminLoginDAO {

	public boolean validateAdmin(AdminLoginBean admin) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("connection established in display code");
		} else {
			System.out.println("check the connection");
		}
		boolean status = false;
		String sql = "select * from login where user_name=? and password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getUser_name());
			pst.setString(2, admin.getPassword());

			ResultSet rs = pst.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int changePassword(AdminLoginBean admin) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("connection established in display code");
		} else {
			System.out.println("check the connection");
		}

		String sql = "update login set password=? where user_name=?";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getPassword());
			pst.setString(2, admin.getUser_name());
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
