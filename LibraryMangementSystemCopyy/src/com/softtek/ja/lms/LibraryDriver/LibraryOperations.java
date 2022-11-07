package com.softtek.ja.lms.LibraryDriver;

import java.util.Scanner;

public class LibraryOperations 
{
	static BookOperation op1=new BookOperation();
	static MemberOperations mp1=new MemberOperations();
	static LibrarianOperations lp1=new LibrarianOperations();

	void exit()
	{
		System.out.println(Constants.LOGOUT_MESSAGE);
		System.exit(0);
	}

	/*
	 * Method that allows the librarian to perform desired operation
	 */
	void execute() throws Exception
	{
		System.out.println("1- Book Operations");
		System.out.println("2-Member Operations");
		System.out.println("3-Librarian Operations");
		System.out.println("4-Exit");
		System.out.println("Enter the option");
		Scanner sc=new Scanner(System.in);
		int input = sc.nextInt();
		switch(input)
		{
		case 1: System.out.println("Book Operations");
		System.out.println(Constants.GET_BOOK);
		System.out.println(Constants.POST_BOOK);
		System.out.println(Constants.DELETE_BOOK);
		System.out.println("Press 4-To issue the book");
		System.out.println("Press 5- Get Count of each book");
		System.out.println();
		//System.out.println(Constants.UPDATE_BOOK);
		Validator v1=new Validator();
		System.out.println("Enter the option to perform any one of CRUD operation");
		int subinput=sc.nextInt();
		switch(subinput)
		{
		case 1: op1.read();
		execute();
		break;
		case 2: op1.add();
		execute();
		break;
		case 3:op1.delete();
		execute();
		break;
		case 4:v1.viewAllBooksForIssueBook();
		v1.issueBook();
		execute();
		break;
		case 5:v1.bookCount();
		break;

		default : System.out.println("Invalid Choice, Enter Valid Option");
		execute();
		break;
		}
		break;


		case 2:System.out.println("Member Operations");
		System.out.println("1- To read member data");
		System.out.println("2-To add member");
		System.out.println("3-To delete a member");
		System.out.println("Enter the option to perform any one of CRUD operation");
		int subinput2=sc.nextInt();
		switch(subinput2)
		{
		case 1: mp1.read();
		execute();
		break;
		case 2: mp1.add();
		execute();
		break;
		case 3:mp1.delete();
		execute();
		break;
		default: System.out.println("Invalid Choice, Enter Valid Option");
		execute();
		break;
		}

		case 3: System.out.println("Librarian Operations");
		System.out.println("1- To read librarian data");
		System.out.println("2-To add librarian");
		System.out.println("3-To delete librarian");
		System.out.println("Enter the option to perform any one of CRUD operation");
		int subinput3=sc.nextInt();
		switch(subinput3)
		{
		case 1: lp1.read();
		execute();
		break;
		case 2: lp1.add();
		execute();
		break;
		case 3:lp1.delete();
		execute();
		break;
		}
		break;

		case 4: exit();
		break;

		default:System.out.println("Invalid Choice, Enter Valid Option");
		execute();
		break;
		}
	}

}







