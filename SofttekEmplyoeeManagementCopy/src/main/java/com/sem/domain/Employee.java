package com.sem.domain;

public class Employee 
{
	private String emp_id;
	private String is_id;
	private String first_name;
	private String last_name;
	private String address;
	private String birth_date;
	private String gender;
	private String email_id;
	private String contact_no;
	private String joining_date;
	private String emp_type;
	private String emp_status;
	private int exp_level;

	public Employee() {
	}

	public Employee(String emp_id, String is_id, String first_name, String last_name, String address, String birth_date,
			String gender, String email_id, String contact_no, String joining_date, String emp_type, String emp_status,
			int exp_level) {
		super();
		this.emp_id = emp_id;
		this.is_id = is_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.birth_date = birth_date;
		this.gender = gender;
		this.email_id = email_id;
		this.contact_no = contact_no;
		this.joining_date = joining_date;
		this.emp_type = emp_type;
		this.emp_status = emp_status;
		this.exp_level = exp_level;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getIs_id() {
		return is_id;
	}

	public void setIs_id(String is_id) {
		this.is_id = is_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}

	public int getExp_level() {
		return exp_level;
	}

	public void setExp_level(int exp_level) {
		this.exp_level = exp_level;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", is_id=" + is_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", birth_date=" + birth_date + ", gender=" + gender
				+ ", email_id=" + email_id + ", contact_no=" + contact_no + ", joining_date=" + joining_date
				+ ", emp_type=" + emp_type + ", emp_status=" + emp_status + ", exp_level=" + exp_level + "]";
	}

}

//CREATE TABLE `softtek_employee` (
//		  `emp_id` varchar(10) NOT NULL,
//		  `is_id` varchar(6) NOT NULL,
//		  `first_name` varchar(45) NOT NULL,
//		  `last_name` varchar(45) NOT NULL,
//		  `address` varchar(120) NOT NULL,
//		  `birth_date` date NOT NULL,
//		  `gender` char(1) NOT NULL,
//		  `email_id` varchar(45) NOT NULL,
//		  `contact_no` varchar(10) NOT NULL,
//		  `joining_date` date NOT NULL,
//		  `emp_type` varchar(3) NOT NULL,
//		  `emp_status` char(1) NOT NULL,
//		  `exp_level` int NOT NULL,
//		  PRIMARY KEY (`emp_id`),
//		  UNIQUE KEY `emp_id_UNIQUE` (`emp_id`),
//		  UNIQUE KEY `email_id_UNIQUE` (`email_id`)
//		)