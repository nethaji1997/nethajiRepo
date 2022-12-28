package com.nethaji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Create 
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
		//	stmt = conn.createStatement();
//			stmt.executeUpdate("insert into person (pname,age,passport_No) values('pushpa',50,2345)");
//			stmt.executeUpdate("insert into person values('nanu',90,565)");
			pstmt=conn.prepareStatement("insert into person values(?,?,?)");
			pstmt.setString(1,"chandu");
			pstmt.setInt(2, 80);
			pstmt.setInt(3,987);
			pstmt.executeUpdate();
			System.out.println("inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
