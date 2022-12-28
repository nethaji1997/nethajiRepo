package com.nethaji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Update 
{
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static ResultSetMetaData rsm;
	static PreparedStatement pstmt;

	public static void main(String[] args) throws SQLException 
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Softtek@2022");
			stmt = conn.createStatement();
			//stmt.executeUpdate("update person set pname='nanu' where age=60");
			//stmt.executeUpdate("update person set pname='kinil', age=60 where passport_No=565");
			pstmt=conn.prepareStatement("update person set pname=? where passport_No=?");
			pstmt.setString(1,"chandana gowda");
			pstmt.setInt(2, 987);
			pstmt.executeUpdate();
			System.out.println("updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
