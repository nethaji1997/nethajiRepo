package com.softtek.ja.lms.LibraryDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.softtek.ja.lms.domainObjects.Book;
import com.softtek.ja.lms.domainObjects.Librarian;
import com.softtek.ja.lms.domainObjects.Member;

interface Operations 
{
	void add();
	void delete();
	void read();
	void update();
}

/*
 * Class that performs CRUD operations related to Book
 */
class BookOperation extends Book implements Operations
{
	static Scanner sc=new Scanner(System.in);
	static Connection con;
	static java.sql.PreparedStatement pstmt = null;
	static Statement stmt;
	static ResultSet rs;

	/*
	 * Method to add a book into the library
	 */

	public void add()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		System.out.println("Enter the book Id");
		intISBN=sc.nextInt();
		System.out.println("Enter the book title");
		strTitle=sc.next();
		System.out.println("Enter the book subject");
		strSubject=sc.next();
		System.out.println("Enter the book language");
		strLanguage=sc.next();
		System.out.println("Enter the book Price");
		intBookPrice=sc.nextInt();
		System.out.println("Enter the book author name");
		strAuthorName=sc.next();

		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			System.out.println("Connection successful");
			pstmt = con.prepareStatement(Constants.INSERT_BOOK_QUERY);
			pstmt.setInt(1, intISBN);
			pstmt.setString(2, strTitle);
			pstmt.setString(3, strSubject);
			pstmt.setString(4, strLanguage);
			pstmt.setInt(5, intBookPrice);
			pstmt.setString(6, strAuthorName);
			pstmt.executeUpdate();
			System.out.println("Record inserted successfully");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Method to retrieve all available books from Library
	 */
	public void read()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			stmt=con.createStatement();
			System.out.println(Constants.BOOK_SELECTION_OPTIONS);
			int options= sc.nextInt();
			if(options==1)
			{
				System.out.println("Select Language \n 1.kannada\n 2.English");
				int x=sc.nextInt();

				switch(x) 
				{
				case 1:
					ResultSet rs1=stmt.executeQuery(Constants.KANNADA_BOOK_QUERY);
					while(rs1.next())
					{
						System.out.println(rs1.getInt(1)+" : "+rs1.getString(2));
					}
					break;
				case 2:
					ResultSet rs2=stmt.executeQuery(Constants.ENGLISH_BOOK_QUERY);
					while(rs2.next())
					{
						System.out.println(rs2.getInt(1)+" : "+rs2.getString(2));
					}
					Validator.bookSelection();
					break;
				}
				Validator.bookSelection();
			}

			else if(options==2) {
				System.out.println("Select Subjects \n 1.Programming \n 2.Epic");
				int x=sc.nextInt();

				switch(x) 
				{
				case 1:
					ResultSet rs3=stmt.executeQuery("Select * from book where lower(strSubject)='Programming'");
					while(rs3.next())
					{
						System.out.println(rs3.getInt(1)+" : "+rs3.getString(2));
					}
					break;

				case 2:
					ResultSet rs4=stmt.executeQuery("Select * from book where lower(strSubject)='Epic'");
					while(rs4.next())
					{
						System.out.println(rs4.getInt(1)+" : "+rs4.getString(2));
					}
					Validator.bookSelection();
					break;
				}
				Validator.bookSelection();

			}
			else if(options==3) 
			{
				System.out.println("Select Authors \n 1.kuvempu \n 2. gosling");
				int x=sc.nextInt();
				switch(x) 
				{
				case 1:
					ResultSet rs4=stmt.executeQuery("Select book.intISBN, book.strTitle from book, author "
							+ "where book.intISBN=author.intISBN and lower(author.strAuthorName)='kuvempu'");
					while(rs4.next())
					{
						System.out.println(rs4.getInt(1)+" : "+rs4.getString(2));
					}
					break;

				case 2:
					ResultSet rs5=stmt.executeQuery("Select book.intISBN, book.strTitle from book, author "
							+ "where book.intISBN=author.intISBN and lower(author.strAuthorName)='gosling'");
					while(rs5.next())
					{
						System.out.println(rs5.getInt(1)+" : "+rs5.getString(2));
					}	
					break;
				}
				Validator.bookSelection();
			}
			else if(options==4)
			{
				Validator.viewAllBooks();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void update()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		Scanner sc=new Scanner(System.in);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("update book set strTitle=?, set strSubject=?,set strLanguage=?, set intBookPrice=?,set strAuthorName=? where intISBN=?");

			System.out.println("Enter the book Id to update the book");
			intISBN=sc.nextInt();
			pstmt.setInt(intISBN, intISBN);

			System.out.println("Enter the book title");
			strTitle=sc.next();
			pstmt.setString(2, strTitle);

			System.out.println("Enter the book subject");
			strSubject=sc.next();
			pstmt.setString(3, strSubject);

			System.out.println("Enter the book language");
			strLanguage=sc.next();
			pstmt.setString(4, strLanguage);


			System.out.println("Enter the book Price");
			intBookPrice=sc.nextInt();
			pstmt.setInt(5, intBookPrice);


			System.out.println("Enter the book author name");
			strAuthorName=sc.next();
			pstmt.setString(6, strAuthorName);

			pstmt.executeUpdate();

			System.out.println("Record Updated successfully");
		} 

		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/** for deleting the book details**/

	public void delete()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book Id to delete the book");
		intISBN=sc.nextInt();
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("delete from book "+ "where intISBN=?");
			pstmt.setInt(1, intISBN);
			System.out.println("Record deleted successfully");
			pstmt.executeUpdate();
		}

		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
}

//class AuthorOperations extends Author implements Operations
//{
//	Connection con;
//	java.sql.PreparedStatement pstmt = null;
//	Statement stmt;
//	ResultSet rs;
//
//	/**For Adding the Author **/
//
//	public void add()
//	{
//		System.out.println("WELCOME TO SOFTTEK LIBRARY");
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the Author Name");
//		strAuthorName=sc.next();
//		System.out.println("Enter the Author Id ");
//		intAuthorId=sc.nextInt();
//		System.out.println("Enter the Author Mbl Number");
//		lngAuthorMblno=sc.nextLong();
//		System.out.println("Enter the Author Email language");
//		strAuthorEmail=sc.next();
//		try 
//		{
//			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
//			System.out.println("Connection successful");
//			pstmt = con.prepareStatement("INSERT INTO author(strAuthorName, intAuthorId, lngAuthorMblNo, strAuthorEmail) VALUES(?,?,?,?)");
//			pstmt.setString(1, strAuthorName);
//			pstmt.setInt(2, intAuthorId);
//			pstmt.setLong(3, lngAuthorMblno);
//			pstmt.setString(4, strAuthorEmail);
//			System.out.println("Record inserted successfully");
//			pstmt.executeUpdate();
//
//		} 
//		catch (SQLException e) 
//		{
//
//			e.printStackTrace();
//		}
//	}
//
//
//	/** For Retrieving Author details**/
//
//	public void read()
//	{
//		System.out.println("WELCOME TO SOFTTEK LIBRARY");
//		try
//		{
//			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
//			stmt=con.createStatement();
//			rs=stmt.executeQuery("select * from author");
//			System.out.println("The author details available are as follows");
//			System.out.println("-----------------------------------------");
//			while(rs.next())
//			{
//				System.out.println(rs.getString("strAuthorName")+" : "+rs.getInt("intAuthorId")
//				+" : "+rs.getLong("lngAuthorMblNo")+" : "+rs.getString("strAuthorEmail"));
//			}
//		}
//		catch (SQLException e) 
//		{
//
//			e.printStackTrace();
//		}
//	}
//
//	public void update()
//	{
//
//	}
//	/** for deleting Author details**/
//
//	public void delete()
//	{
//		System.out.println("WELCOME TO SOFTTEK LIBRARY");
//		Scanner sc=new Scanner(System.in);
//		intAuthorId=sc.nextInt();
//		try 
//		{
//			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
//			pstmt=con.prepareStatement("delete from author "+ "where intAuthorId=?");
//			pstmt.setInt(1, intAuthorId);
//			System.out.println("Record deleted successfully");
//			pstmt.executeUpdate();
//		}
//
//		catch (SQLException e) 
//		{
//
//			e.printStackTrace();
//		}
//	} 
//}

class LibrarianOperations extends Librarian implements Operations
{
	static Connection con;
	static java.sql.PreparedStatement pstmt = null;
	static Statement stmt;
	static ResultSet rs;

	/** For Adding a Librarian into the library**/

	public void add()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Librarian  Id");
		intLibrarianId=sc.nextInt();
		System.out.println("Enter the Librarian  Name ");
		strLibrarianName=sc.next();
		System.out.println("Enter the Librarian Email");
		strLibrarianEmail=sc.next();
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			System.out.println("Connection successful");
			pstmt = con.prepareStatement("INSERT INTO librarian(intLibrarianId, strLibrarianName, strLibrarianEmail) VALUES(?,?,?)");
			pstmt.setInt(1, intLibrarianId);
			pstmt.setString(2, strLibrarianName);
			pstmt.setString(3, strLibrarianEmail);
			System.out.println("Record inserted successfully");
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}


	/** For Reading the librian details**/
	public void read()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from librarian");
			System.out.println("The librarian details in our library are as follows");
			System.out.println("------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt("intLibrarianId")+" : "+rs.getString("strLibrarianName")
				+" : "+rs.getString("strLibrarianEmail"));
			}
		}
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public void update()

	{

	}

	/** for deleting the book details**/

	public void delete()
	{
		System.out.println("Enter Member to Delete");
		Scanner sc=new Scanner(System.in);
		intLibrarianId=sc.nextInt();
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("delete from librarian "+ "where intLibrarianId=?");
			pstmt.setInt(1, intLibrarianId);
			System.out.println("Record deleted successfully");
			pstmt.executeUpdate();
		}

		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	} 
}


class MemberOperations extends Member implements Operations
{
	Connection con;
	java.sql.PreparedStatement pstmt = null;
	Statement stmt;
	ResultSet rs;

	/** For Adding a Member into the Table**/

	public void add()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Member  Id");
		intMemberId=sc.nextInt();
		System.out.println("Enter the Member  Name ");
		strMemberName=sc.next();
		System.out.println("Enter the Member Mbl No");
		memberMobileNo=sc.nextLong();
		System.out.println("Enter the member Email");
		strMemberEmail=sc.next();
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			System.out.println("Connection successful");
			pstmt = con.prepareStatement("INSERT INTO member(intMemberId, strMemberName, memberMblNo, memberEmail) VALUES(?,?,?,?)");
			pstmt.setInt(1, intMemberId);
			pstmt.setString(2, strMemberName);
			pstmt.setLong(3, memberMobileNo);
			pstmt.setString(4, strMemberEmail);
			System.out.println("Please pay 500/- as deposit so that you will become a member of SOFTTEK Library");
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}

	/** For Reading the member details**/

	public void read()
	{
		System.out.println("WELCOME TO SOFTTEK LIBRARY");
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from member");
			System.out.println("The member details in our library are as follows");
			System.out.println("------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt("intMemberId")+" : "+rs.getString("strMemberName")
				+" : "+rs.getString("memberMblNo")+" : "+rs.getString("memberEmail"));
			}
		}
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public void update()
	{

	}

	/** for deleting the member details**/
	public void delete()
	{
		System.out.println("Enter the Member Id To delete");
		Scanner sc=new Scanner(System.in);
		intMemberId=sc.nextInt();
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
			pstmt=con.prepareStatement("delete from member "+ "where intMemberId=?");
			pstmt.setInt(1, intMemberId);
			System.out.println("Member deleted successfully");
			pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
}

class Basic extends Book
{



	//	void returnBook() throws Exception
	//	{
	//		Connection con;
	//		PreparedStatement pstmt;
	//		Scanner sc=new Scanner(System.in);
	//
	//		System.out.println("Enter the Member Id");
	//		int memberId = sc.nextInt();
	//		con = DriverManager.getConnection("jdbc:mysql://localhost/lms", "root", "Softtek@2022");
	//		Statement stmt=con.createStatement();
	//		ResultSet rs=stmt.executeQuery("select intMemberId,intISBN from member");
	//		//while(rs.next())
	//		//{
	//		rs.next();
	//		int memberIdDb=rs.getInt(1);
	//		int bookIdDb=rs.getInt(2);
	//
	//		if(bookId==bookIdDb && memberId == memberIdDb)
	//		{
	//			System.out.println("Book Returned Successfully");
	//		}
	//		else
	//		{
	//			System.out.println("Please enter valid id to return the book");
	//		}
	//	}
}


//		if(intISBN==bookId)
//		{
//			System.out.println("Total Details are as below:-");
//			System.out.println("Book Name "+strTitle);
//			System.out.println("Book Id "+intISBN);
//			System.out.println("Issue Date "+issueDate);
//			System.out.println("Total number of books Issued - "+totalBooks);
//			System.out.println("Book return date - "+returnDate);
//		}
//		else
//		{
//			System.out.println("Wrong Id, Please enter valid book Id");
//		}


//void details()
//{
//	System.out.println("Book Name "+strTitle);
//	System.out.println("Book Id "+intISBN);
//	System.out.println("Issue Date "+issueDate);
//	System.out.println("Total number of books issued "+totalBooks);
//	System.out.println("Book return date "+returnDate);
//}

















