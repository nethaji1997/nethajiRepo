package com.sem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	static LoginServlet login = new LoginServlet();
	private static final long serialVersionUID = 1L;

	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	private static List<Employee> listEmployee;

	public void init() {
		listEmployee = employeeDAO.ViewAllEmployee();
	}

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		try {
			switch (path) {
			case "/":
				login.doGet(request, response);
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

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

//	protected static void listEmployee(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//
//		List<Employee> employee = employeeDAO.ViewAllEmployee();
//		request.setAttribute("listEmployees", employee);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/listemployee.jsp");
//		dispatcher.forward(request, response);
//
//	}
	protected void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		init();
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));// 3
		}
		int recordsPerPage = 5;
		int size = listEmployee.size();// 16
		int start = (currentPage * recordsPerPage) - recordsPerPage;// 10
		if ((size - start) < recordsPerPage) {
			List<Employee> subEmployeeList = listEmployee.subList(start, size);// 15,16
			request.setAttribute("listEmployees", subEmployeeList);
		} else {
			List<Employee> subEmployeeList = listEmployee.subList(start, (start + recordsPerPage));// 10,15
			request.setAttribute("listEmployees", subEmployeeList);
		}

//		List<Employee> subEmployeeList = listEmployee.subList(start, (start + recordsPerPage));//10,15
//		request.setAttribute("listEmployees", subEmployeeList);

		int rows = employeeDAO.GetNumberOfRows();// 12
		int nOfPages = rows / recordsPerPage;// 2.3-->2
		if (nOfPages % recordsPerPage > 0) {
			nOfPages++;
		}

		request.setAttribute("noOfPages", nOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/listemployee.jsp");
		dispatcher.forward(request, response);

	}

	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addemployee.jsp");
		dispatcher.forward(request, response);
	}

	protected void insertEmployee(HttpServletRequest request, HttpServletResponse response)
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
		init();
		response.sendRedirect("list");
	}

	protected void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String emp_id = request.getParameter("emp_id");
		Employee viewEmployee = employeeDAO.ViewEmployee(emp_id);
		request.setAttribute("viewEmployee", viewEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewemployee.jsp");
		dispatcher.forward(request, response);
	}

	protected void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		Employee emp = employeeDAO.ViewEmployee(emp_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/updateEmployee.jsp");
		request.setAttribute("employee", emp);
		dispatcher.forward(request, response);

	}

	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response)
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
		init();
		response.sendRedirect("list");
	}

	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_id = request.getParameter("emp_id");
		employeeDAO.DeleteEmployee(emp_id);
		init();
		response.sendRedirect("list");
	}

	// protected void loginValidation(HttpServletRequest request,
	// HttpServletResponse response)
	// throws IOException, ServletException, SQLException {
	// String uname = request.getParameter("uname");
	// String password = request.getParameter("pass");
	// EmployeeDAO dao = new EmployeeDAO();
	// if (dao.check(uname, password)) {
	// HttpSession session = request.getSession();
	// session.setAttribute("username", uname);
	// RequestDispatcher rd =
	// request.getRequestDispatcher("/WEB-INF/views/listemployee.jsp");
	// rd.forward(request, response);
	// listEmployee(request, response);
	//
	// } else {
	// RequestDispatcher rd =
	// request.getRequestDispatcher("/WEB-INF/views/login.jsp");
	// rd.forward(request, response);
	// }
	// }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
