package com.sem.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sem.dao.EmployeeDAO;
import com.sem.dao.IEmployeeDAO;

public class EmployeeHelper {

	public static String getEmpID() {
		try {
			Connection connect = EmployeeDAO.getConnection();
			connect = DriverManager.getConnection(IEmployeeDAO.jdbcURL, IEmployeeDAO.jdbcUsername,
					IEmployeeDAO.jdbcPassword);
			PreparedStatement statement = connect
					.prepareStatement("select emp_id from softtek_employee ORDER BY emp_id DESC LIMIT 1");
			ResultSet rs1 = statement.executeQuery();

			if (rs1.next()) {
				String emp_id = rs1.getString("emp_id");
				String u = emp_id.substring(4);
				int num = Integer.parseInt(u);
				num++;
				emp_id = "ASP0" + Integer.toString(num);
				return emp_id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "ASP01230";
	}

	public static String getISID(String first_name, String last_name) {
		String isid = "";
		if (first_name.length() >= 2 && last_name.length() >= 2) {
			isid = isid + first_name.substring(0, 2) + last_name.substring(0, 2);
			isid = isid.toUpperCase();
		} else if (first_name.length() == 1 && last_name.length() == 1) {
			isid = isid + first_name.charAt(0) + last_name.charAt(0);
			isid = isid.toUpperCase();
		} else if (first_name.length() >= 2 && last_name.length() == 1) {
			isid = isid + first_name.charAt(0) + last_name.charAt(0);
			isid = isid.toUpperCase();
		} else if (first_name.length() == 1 && last_name.length() >= 2) {
			isid = isid + first_name.charAt(0) + last_name.charAt(0);
			isid = isid.toUpperCase();
		} else if (first_name.length() >= 2 && last_name.length() == 0) {
			isid = isid + first_name.substring(0, 3);
			isid = isid.toUpperCase();
		}
		return isid;
	}

	public static String getEmailID(String first_name, String last_name) {
		String emailID = first_name + "." + last_name + "@softtek.com";
		return emailID.toLowerCase();
	}

	public static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();
		String strDate = df.format(today);
		return strDate;
	}

	public static void main(String[] args) {
		//		System.out.println(getISID("manish", ""));
		//		System.out.println(getEmailID("gowrav", "c"));
		//		System.out.println(getEmpID());
		//		System.out.println(getEmpID());
		//		System.out.println(getEmpID());
		System.out.println(getCurrentDate());

		System.out.println(getEmpID());
	}
}
