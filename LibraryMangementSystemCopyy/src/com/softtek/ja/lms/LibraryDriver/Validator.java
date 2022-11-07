package com.softtek.ja.lms.LibraryDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.softtek.ja.lms.domainObjects.Librarian;

public class Validator extends Librarian
{
	static MemberOperations mo=new MemberOperations();
	static Scanner s=new Scanner(System.in);
	static Librarian l1=new Librarian();
	static Statement stmt;
	static ResultSet rs;
	static Connection con;
	static LocalDateTime ldt;
	static PreparedStatement pstmt;

	/*
	 * Method to give count of book by its title
	 */
	void bookCount()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book title");
		String inputBookTitle = sc.next();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("select strTitle, count(*) from book where strTitle=?");
			pstmt.setString(1,inputBookTitle);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("The total books available are "+rs.getInt(2));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*
	 * Method that helps us to issue the book to the user/member
	 */
	void issueBook() throws Exception
	{
		Connection con;
		PreparedStatement pstmt;
		Scanner sc=new Scanner(System.in);
		System.out.println("Book Id");
		int intISBN=sc.nextInt();
		System.out.println("Member Id");
		int intMemberId=sc.nextInt();
		System.out.println("Book issue date");
		String issueDate=sc.next();
		System.out.println("Return date");
		String returnDate = sc.next();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("insert into issuebook(intISBN,intMemberId,issuedate,returndate) values(?,?,?,?)");
			pstmt.setInt(1,intISBN);
			pstmt.setInt(2, intMemberId);
			pstmt.setString(3, issueDate);
			pstmt.setString(4, returnDate);
			System.out.println("Book Issued Successfully");
			pstmt.executeUpdate();
			System.out.println();
			BookOperation b1=new BookOperation();
			System.out.println("Enter the book id to remove from library");
			int issueBookToDelete=sc.nextInt();
			b1.delete();
			System.out.println("Book deleted successfully");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * Method to view all the books available in the library for librarian
	 */
	static void viewAllBooks() throws Exception
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try 
		{
			rs=stmt.executeQuery(Constants.GET_BOOK_DETAILS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The book details in our library are as follows");
		System.out.println("------------------------------------------");
		try {
			while(rs.next())
			{
				System.out.println(rs.getInt("intISBN")+" : "+rs.getString("strTitle")
				+" : "+rs.getString("strSubject")+" : "+rs.getString("strLanguage")+" : "+rs.getInt("intBookPrice"));
			}
			System.out.println();
			bookSelection();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Method to view all the books available in the library for issuing the book
	 */
	static void viewAllBooksForIssueBook() throws Exception
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try 
		{
			rs=stmt.executeQuery(Constants.GET_BOOK_DETAILS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The book details in our library are as follows");
		System.out.println("------------------------------------------");
		try {
			while(rs.next())
			{
				System.out.println(rs.getInt("intISBN")+" : "+rs.getString("strTitle")
				+" : "+rs.getString("strSubject")+" : "+rs.getString("strLanguage")+" : "+rs.getInt("intBookPrice"));
			}
			System.out.println();
			Validator v2=new Validator();
			v2.issueBook();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Method to view all the books available in the library only for the user
	 */
	static void viewAllBooksForUser() throws Exception
	{
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
		} catch (SQLException e1) 
		{	
			e1.printStackTrace();
		}
		try 
		{
			stmt=con.createStatement();
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			rs=stmt.executeQuery(Constants.GET_BOOK_DETAILS);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println("The book details in our library are as follows");
		System.out.println("------------------------------------------");
		try {
			while(rs.next())
			{
				System.out.println(rs.getInt("intISBN")+" : "+rs.getString("strTitle")
				+" : "+rs.getString("strSubject")+" : "+rs.getString("strLanguage")+" : "+rs.getInt("intBookPrice"));
			}
			System.out.println();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * After viewing all books, this method helps us to select the desired book based on Book Id
	 */
	static void bookSelection() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Statement stmt1=null;
		System.out.println("Do you need the book Y / N");

		char x=sc.next().charAt(0);
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt1=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(x=='Y'||x=='y') 
		{
			System.out.println("Enter the book Id to select the book");
			ResultSet rs1=stmt1.executeQuery
					("select book.intISBN, rack.intRackNumber,rack.locationIdentifier "
							+ "from book,rack where book.intISBN=rack.intISBN"
							);
			while(rs1.next())
			{
				int input = sc.nextInt();

				if(input<12)
				{
					LocalDate currentdate = LocalDate.now();
					int currentDay = currentdate.getDayOfMonth();
					Month currentMonth = currentdate.getMonth();
					int currentYear = currentdate.getYear();
					System.out.println("Congrats!!! you have been assign with book id "+input +" : Present in rack no "+
							rs1.getString(2) +" and  Rack Location "+rs1.getString(3)+" on "+currentDay+"  "+currentMonth +" "+currentYear);
					//					try 
					//					{
					//						con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
					//						pstmt=con.prepareStatement("delete from book "+ "where intISBN=?");
					//						pstmt.setInt(1,input);
					//						pstmt.executeUpdate();
					//						LibraryOperations l1=new LibraryOperations();
					//						l1.execute();
					//					}
					//					catch (SQLException e) 
					//					{
					//						e.printStackTrace();
					//					}
					LibraryOperations l1=new LibraryOperations();
					l1.execute();
				}
				else
				{
					System.out.println("Sorry book not available");
				}
			}
		}
		else if(x=='N'||x=='n')
		{
			LibraryOperations l11=new LibraryOperations();
			l11.execute();

		}
		else if(x!='N'||x!='n'||x!='Y'||x!='y')
		{
			bookSelection();
		}
	}

	/*
	 * Method to switch the login as 1) User 2) Librarian
	 */
	void switcLogin() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Softtek Library");
		System.out.println("1- Librarian\n2- User");
		System.out.println("Enter Your Choice");
		int input=sc.nextInt();
		switch(input)
		{
		case 1: librarianValidation();
		break;

		case 2: userValidation();
		}
	}

	/*
	 * Method that helps the user for viewing all books in our library
	 */
	static void userValidation() throws Exception
	{
		System.out.println("Welcome User");
		viewAllBooksForUser();

	}

	/*
	 * Method that helps the librarian to perform required action by entering username and password
	 */
	static void librarianValidation() 
	{
		System.out.println("Welcome Librarian");
		System.out.println("---------------------");
		String librarianUserName=nameValidation();
		System.out.println("Enter Password");
		String librarianPassword=s.next();
		if(librarianUserName.equalsIgnoreCase(l1.getLibrarianUserName1()) && librarianPassword.equalsIgnoreCase(l1.getLibrarianPassword1())) 
		{
			System.out.println("Hi "+librarianUserName);
		}
		else if(librarianUserName.equalsIgnoreCase(l1.getLibrarianUserName2()) && librarianPassword.equalsIgnoreCase(l1.getLibrarianPassword2()))
		{
			System.out.println("Hi "+librarianUserName);
		}
		else
		{
			System.out.println("Incorrect username or Password, \n Enter Valid username and Password");
			librarianValidation();
		}
	}

	/*
	 * Method to ensure that username text field should accept only alphabets
	 */
	static String nameValidation()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String name = sc.next();
		String regex = "[a-zA-Z]+\\.?";
		if(name.matches(regex)) 
		{
			return name;
		}else
		{
			System.out.println("Invaild User Name");
		}
		return nameValidation();

	}

}

//System.out.print("Mobile No:-");
//String mobilNo=scan.next();
//String regex = "(0/91)?[7-9][0-9]{9}";
//if(!mobilNo.matches(regex)) {
//System.out.println("Your phone number is not valid");
//System.out.println("please enter a valid phone number");
//System.out.println();
//System.out.print("Mobile No:-");
//mobilNo=scan.next();
//}
//
//
//
//System.out.print("Mail-ID:-");
//String mailID=scan.next();
//String regexPattern = "^(.+)@(\\S+)$";
//if(!mobilNo.matches(regex)) {
//System.out.println("Your mail-ID is not valid");
//System.out.println("please enter a valid mail-ID");
//System.out.println();
//System.out.print("Mail-ID:-");
//mailID=scan.next();
//}
//has context menu


//void login() {
//System.out.println("---Please register & login to order food---");
//
//
//System.out.print("Name:-");
//String name=scan.next();
//String namepattern = "[a-zA-Z]+\\.?";
//if(!name.matches(namepattern)) {
//System.out.println("Your username is not valid");
//System.out.println("please enter a valid user name");
//System.out.println();
//System.out.print("Name:-");
//name=scan.next();
//}
//
//
//
//System.out.print("Mobile No:-");
//String mobilNo=scan.next();
//String regex = "(0/91)?[7-9][0-9]{9}";
//if(!mobilNo.matches(regex)) {
//System.out.println("Your phone number is not valid");
//System.out.println("please enter a valid phone number");
//System.out.println();
//System.out.print("Mobile No:-");
//mobilNo=scan.next();
//}
//
//
//
//System.out.print("Mail-ID:-");
//String mailID=scan.next();
//String regexPattern = "^(.+)@(\\S+)$";
//if(!mobilNo.matches(regex)) {
//System.out.println("Your mail-ID is not valid");
//System.out.println("please enter a valid mail-ID");
//System.out.println();
//System.out.print("Mail-ID:-");
//mailID=scan.next();
//}

