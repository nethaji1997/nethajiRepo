package com.sem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sem.dao.EmployeeDAO;
import com.sem.dao.IEmployeeDAO;
import com.sem.domain.Employee;
import com.sem.helper.EmployeeHelper;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDAO employeeDAO;

	public EmployeeServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		employeeDAO = new EmployeeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		try {
			switch (path) {
			case "/":
				listEmployee(request, response);
				break;
			case "/list":
				listEmployee(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/view":
				viewEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
//			case "/p_to_c":
//				comfirmEmployee(request, response);
//				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Employee> employee = employeeDAO.ViewAllEmployee();
		request.setAttribute("listEmployees", employee);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/listemployee.jsp");
		dispatcher.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addemployee.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		String birth_date = request.getParameter("birth_date");
		String gender = request.getParameter("gender");
		String contact_no = request.getParameter("contact_no");
		String emp_type = request.getParameter("emp_type");

		Employee emp = new Employee(EmployeeHelper.getEmpID(), EmployeeHelper.getISID(first_name, last_name),
				first_name, last_name, address, birth_date, gender, EmployeeHelper.getEmailID(first_name, last_name),
				contact_no, EmployeeHelper.getCurrentDate(), emp_type, IEmployeeDAO.EMP_STATUS, 0);
		employeeDAO.AddEmployee(emp);
		response.sendRedirect("list");
	}

	private void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String emp_id = request.getParameter("emp_id");
		Employee viewEmployee = employeeDAO.ViewEmployee(emp_id);
		request.setAttribute("viewEmployee", viewEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewemployee.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		Employee emp = employeeDAO.ViewEmployee(emp_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/updateEmployee.jsp");
		request.setAttribute("employee", emp);
		dispatcher.forward(request, response);

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_id = request.getParameter("emp_id");
		String is_id = request.getParameter("is_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String birth_date = request.getParameter("birth_date");
		String email_id = request.getParameter("email_id");
		String contact_no = request.getParameter("contact_no");
		String joining_date = request.getParameter("joining_date");
		String emp_type = request.getParameter("emp_type");
		String emp_status = request.getParameter("emp_status");
		Integer exp_level = Integer.parseInt(request.getParameter("exp_level"));

		Employee emp = new Employee(emp_id, is_id, first_name, last_name, address, birth_date, gender, email_id,
				contact_no, joining_date, emp_type, emp_status, exp_level);
		employeeDAO.UpdateEmployee(emp);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_id = request.getParameter("emp_id");
		employeeDAO.DeleteEmployee(emp_id);
		response.sendRedirect("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
