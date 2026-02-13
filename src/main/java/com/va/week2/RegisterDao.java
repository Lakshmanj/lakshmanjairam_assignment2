package com.va.week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
	/*
	 * Write the methods for CRUD operation..
	 */

	private String dbUrl = "jdbc:mysql://10.252.245.61:3306/cpan368"; // ipaddr command used in terminal in VM to obtain the IP used
	private String dbUname = "lakshmanjairam_cpan368";
	private String dbPassword = "class123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";


	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// this is a helper method to get the connection to the mysql db from within the VM
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


	public String registerForm(RegisterForm student) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";

		// SQL matching the new 'Users' table
		String sql = "INSERT INTO Users (username, password, email, mobileNumber) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			// Set all 4 fields from the form
			ps.setString(1, student.getUsername());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getMobileNumber());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}

	// SELECT fetches real user data
	public List<RegisterForm> getAllUsers() {
		loadDriver(dbDriver);
		Connection con = getConnection();
		List<RegisterForm> userList = new ArrayList<>();

		String sql = "SELECT * FROM Users";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				RegisterForm s = new RegisterForm();
				s.setUsername(rs.getString("username"));
				s.setEmail(rs.getString("email"));
				s.setMobileNumber(rs.getString("mobileNumber"));
				userList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
