package com.nethaji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static ResultSetMetaData rsm;
	static PreparedStatement pstmt;

	public static void main(String[] args) throws SQLException {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "Softtek@2022");
			stmt = conn.createStatement();
			// stmt.executeUpdate("delete from person where passport_No=565");
			// stmt.executeUpdate("insert into person values('nanu',90,565)");
			pstmt = conn.prepareStatement("delete from person where passport_No=?");
			pstmt.setInt(1, 2345);
			pstmt.execute();
			System.out.println("deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
