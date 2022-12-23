package com.sem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sem.domain.Employee;

public class EmployeeDAO implements IEmployeeDAO {

	public EmployeeDAO() {

	}

	// Method to load the Driver
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public boolean AddEmployee(Employee employee) {
		boolean added = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(INSERT_EMPLOYEE_DATA);) {
			preparedStament.setString(1, employee.getEmp_id());
			preparedStament.setString(2, employee.getIs_id());
			preparedStament.setString(3, employee.getFirst_name());
			preparedStament.setString(4, employee.getLast_name());
			preparedStament.setString(5, employee.getAddress());
			preparedStament.setString(6, employee.getBirth_date());
			preparedStament.setString(7, employee.getGender());
			preparedStament.setString(8, employee.getEmail_id());
			preparedStament.setString(9, employee.getContact_no());
			preparedStament.setString(10, employee.getJoining_date());
			preparedStament.setString(11, employee.getEmp_type());
			preparedStament.setString(12, employee.getEmp_status());
			preparedStament.setInt(13, employee.getExp_level());
			added = preparedStament.executeUpdate() > 0;
			if (added == true) {
				System.out.println(employee.getEmp_id() + " Employee Data Added to DB");
			} else {
				System.out.println("Employee Data Did'nt Added to DB");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean UpdateEmployee(Employee employee) {
		boolean updated = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(UPDATE_EMPLOYEE_BY_EMPID);) {
			preparedStament.setString(1, employee.getFirst_name());
			preparedStament.setString(2, employee.getLast_name());
			preparedStament.setString(3, employee.getAddress());
			preparedStament.setString(4, employee.getGender());
			preparedStament.setString(5, employee.getBirth_date());
			preparedStament.setString(6, employee.getContact_no());
			preparedStament.setString(7, employee.getEmp_id());
			updated = preparedStament.executeUpdate() > 0;
			if (updated == true) {
				System.out.println(employee.getEmp_id() + " Employee Data Updated in DB");
			} else {
				System.out.println("Employee Data Did'nt Updated in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public List<Employee> ViewAllEmployee() {
		List<Employee> emp = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(GET_ALL_EMPLOYEE_DATA);) {

			ResultSet rs = preparedStament.executeQuery();

			while (rs.next()) {
				String emp_id = rs.getString("emp_id");
				String is_id = rs.getString("is_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String adress = rs.getString("address");
				String birth_date = rs.getString("birth_date");
				String gender = rs.getString("gender");
				String email_id = rs.getString("email_id");
				String contact_no = rs.getString("contact_no");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				int exp_level = rs.getInt("exp_level");

				emp.add(new Employee(emp_id, is_id, first_name, last_name, adress, birth_date, gender, email_id,
						contact_no, joining_date, emp_type, emp_status, exp_level));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee ViewEmployee(String emp_id) {
		Employee emp = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(GET_INDIVDUAL_EMPLOYEE_BY_EMPID);) {
			preparedStament.setString(1, emp_id);
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String emp_id1 = rs.getString("emp_id");
				String is_id = rs.getString("is_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String adress = rs.getString("address");
				String birth_date = rs.getString("birth_date");
				String gender = rs.getString("gender");
				String email_id = rs.getString("email_id");
				String contact_no = rs.getString("contact_no");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				int exp_level = rs.getInt("exp_level");

				emp = new Employee(emp_id1, is_id, first_name, last_name, adress, birth_date, gender, email_id,
						contact_no, joining_date, emp_type, emp_status, exp_level);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public boolean DeleteEmployee(String emp_id) {
		boolean deleted = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(DELETE_INDIVDUAL_EMPLOYEE_BY_EMPID);) {
			preparedStament.setString(1, emp_id);
			deleted = preparedStament.executeUpdate() > 0;
			if (deleted == true) {
				System.out.println(emp_id + " Employee Data Deleted to DB");
			} else {
				System.out.println(emp_id + "Employee Data Did'nt Deleted to DB");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public String ProbationToConfirmation() {
		return null;
	}

}
