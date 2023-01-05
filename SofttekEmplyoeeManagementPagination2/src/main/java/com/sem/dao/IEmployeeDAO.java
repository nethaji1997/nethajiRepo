package com.sem.dao;

import java.util.List;

import com.sem.domain.Employee;

public interface IEmployeeDAO {
	// DB Connections
	public String jdbcURL = "jdbc:mysql://localhost:3306/spring";
	public String jdbcUsername = "root";
	public String jdbcPassword = "Softtek@2022";
	public String jdbcDriver = "com.mysql.cj.jdbc.Driver";

	String EMP_STATUS = "P";

	// Insert
	public String INSERT_EMPLOYEE_DATA = "INSERT INTO softtek_employee values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

	// update
	public String UPDATE_EMPLOYEE_BY_EMPID = "UPDATE softtek_employee SET first_name = ?, last_name = ?, address = ?, gender = ?, birth_date = ?, contact_no = ? where emp_id = ?";

	// Select
	public String GET_ALL_EMPLOYEE_DATA = "SELECT * FROM softtek_employee;";
	public String GET_INDIVDUAL_EMPLOYEE_BY_EMPID = "SELECT * FROM softtek_employee WHERE emp_id= ?";

	// Delete
	public String DELETE_INDIVDUAL_EMPLOYEE_BY_EMPID = "DELETE FROM softtek_employee WHERE emp_id= ?;";

	// methods
	public boolean AddEmployee(Employee employee);

	public boolean UpdateEmployee(Employee employee);

	public List<Employee> ViewAllEmployee();

	public Employee ViewEmployee(String emp_id);

	public boolean DeleteEmployee(String emp_id);

	public String ProbationToConfirmation();

}
