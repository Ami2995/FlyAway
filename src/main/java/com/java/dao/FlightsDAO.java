package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.FlightsBean;
import com.java.helper.DBConnection;

public class FlightsDAO {

// Display Flights
	public List<FlightsBean> showFlights() {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		String sql = "select * from flights";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FlightsBean flight = new FlightsBean();
				flight.setSno(rs.getInt(1));
				flight.setFlight_id(rs.getString(2));
				flight.setSource(rs.getString(3));
				flight.setDestination(rs.getString(4));
				flight.setFlight_name(rs.getString(5));
				flight.setJdate(rs.getString(6));
				flight.setDept_time(rs.getString(7));
				flight.setArr_time(rs.getString(8));
				flight.setPrice(rs.getDouble(9));
				list.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Display Places
	public List<FlightsBean> showPlaces() {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		String sql = "select sno, source, destination from flights";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FlightsBean flight = new FlightsBean();
				flight.setSno(rs.getInt(1));
				flight.setSource(rs.getString(2));
				flight.setDestination(rs.getString(3));
				list.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Display Airlines
	public List<FlightsBean> showAirlines() {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		String sql = "select distinct flight_name from flights";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FlightsBean flight = new FlightsBean();
				flight.setFlight_name(rs.getString(1));
				list.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Insert Flight Details
	public int insertFlights(FlightsBean flight) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}

		String sql = "insert into flights (sno, flight_id, source, destination, flight_name, jdate, dept_time, arr_time, price) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		int row = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, flight.getSno());
			ps.setString(2, flight.getFlight_id());
			ps.setString(3, flight.getSource());
			ps.setString(4, flight.getDestination());
			ps.setString(5, flight.getFlight_name());
			ps.setString(6, flight.getJdate());
			ps.setString(7, flight.getDept_time());
			ps.setString(8, flight.getArr_time());
			ps.setDouble(9, flight.getPrice());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	// Update
	public int updateFlights(FlightsBean flight) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}

		String sql = "update flights set flight_id=?, source=?, destination=?, flight_name=?, jdate=?, dept_time=?, arr_time=?, price=? where sno=?";
		PreparedStatement ps = null;
		int row = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, flight.getFlight_id());
			ps.setString(2, flight.getSource());
			ps.setString(3, flight.getDestination());
			ps.setString(4, flight.getFlight_name());
			ps.setString(5, flight.getJdate());
			ps.setString(6, flight.getDept_time());
			ps.setString(7, flight.getArr_time());
			ps.setDouble(8, flight.getPrice());
			ps.setInt(9, flight.getSno());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	// Delete
	public int deleteFlights(int sNo) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}

		String sql = "delete from flights where sno=?";
		PreparedStatement ps = null;
		int row = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sNo);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	// Search Flights

	public List<FlightsBean> getAvailableFlights(FlightsBean flight) {
		Connection conn = DBConnection.dbconn();
		if (conn != null) {
			System.out.println("Connection establihed");
		} else {
			System.out.println("Check your connection");
		}
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		String sql = "select * from flights where source=? and destination=? and jdate=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, flight.getSource());
			ps.setString(2, flight.getDestination());
			ps.setString(3, flight.getJdate());
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(flight);
				flight.setSno(rs.getInt(1));
				flight.setFlight_id(rs.getString(2));
				flight.setSource(rs.getString(3));
				flight.setDestination(rs.getString(4));
				flight.setFlight_name(rs.getString(5));
				flight.setJdate(rs.getString(6));
				flight.setDept_time(rs.getString(7));
				flight.setArr_time(rs.getString(8));
				flight.setPrice(rs.getDouble(9));
			}
			if (list.isEmpty()) {
				return null;
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
}
