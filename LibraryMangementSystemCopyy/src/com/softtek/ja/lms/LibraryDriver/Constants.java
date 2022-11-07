package com.softtek.ja.lms.LibraryDriver;

public class Constants 
{
	static String GET_BOOK_DETAILS="select * from book";
	static String LOGOUT_MESSAGE="You have Successfully logged out";
	
	static String GET_BOOK="Press 1- To retrieve book details";
	static String POST_BOOK="Press 2- To add a book into library";
	static String DELETE_BOOK="Press 3- To delete book from the library";
//	static String UPDATE_BOOK="Press 4-To update the book details";
	
	static String INSERT_BOOK_QUERY="INSERT INTO book(intISBN, strTitle, strSubject, strLanguage, intBookPrice,strAuthorName) "
			+ "VALUES(?,?,?,?,?,?)";
	static String BOOK_SELECTION_OPTIONS="Select the book by \n 1.Language \n 2.Subject \n 3.Author \n 4.View All Books";
	static String KANNADA_BOOK_QUERY="Select * from book where lower(strLanguage)='kannada'";
	static String ENGLISH_BOOK_QUERY="Select * from book where lower(strLanguage)='english'";
}
