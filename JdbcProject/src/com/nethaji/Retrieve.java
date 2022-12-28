package com.nethaji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrieve 
{
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static ResultSetMetaData rsm;
	public static void main(String[] args) throws SQLException 
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Softtek@2022");
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select * from person");
			rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			for(int i=1; i<=columnCount; i++)
			{
				System.out.print(rsm.getColumnName(i)+" : ");
			}
			System.out.println();
			while(rs.next())
			{
				System.out.println(rs.getString("pname")+" : "+rs.getInt("age")+" : "+rs.getInt("passport_No"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
		stmt.close();
		rs.close();
	}
}
