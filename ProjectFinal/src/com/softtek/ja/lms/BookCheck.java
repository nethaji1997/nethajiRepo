package com.softtek.ja.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Book {

	private JFrame frame;
	private JTextField txtLanguage;
	private JTextField txtId;
	private JTextField txtTitle;
	private JTable table;
	private JTextField txtBookId;
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	private JTextField txtSubject;
	private JTextField txtPrice;
	private JTextField txtAuthor;
	static String bookTitle, bookSubject,bookLanguage,bookAuthor,bookId,bookPrice;
	public static JTextField txtBookCount;


	/**
	 * Launch the application.
	 */

	public static void book() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					LoginPage.maximize();
					Book window = new Book();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Book() 
	{
		initialize();
		tableload();

	}

	static void bookCount()
	{
		String bookCount;
		bookCount=txtBookCount.getText();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");
			pstmt=conn.prepareStatement("select strTitle, count(*) from book where strTitle=?");
			pstmt.setString(1,bookCount);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				JOptionPane.showMessageDialog(null, "The  total book available are "+rs.getString(2));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
	public void tableload()
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			pstmt = conn.prepareStatement("Select * from book");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 0));
		frame.setBounds(100, 100, 979, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 208, 162));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Adding_Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(29, 50, 415, 331);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setBackground(new Color(51, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(10, 35, 137, 32);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Book Sub");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(10, 142, 161, 29);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Book Title");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_2.setBounds(10, 62, 161, 69);
		panel.add(lblNewLabel_1_2);

		txtLanguage = new JTextField();
		txtLanguage.setBounds(191, 189, 194, 29);
		panel.add(txtLanguage);
		txtLanguage.setColumns(10);

		txtId = new JTextField();
		txtId.setBackground(new Color(255, 255, 255));
		txtId.setForeground(new Color(0, 0, 0));
		txtId.setColumns(10);
		txtId.setBounds(191, 41, 194, 32);
		panel.add(txtId);

		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(191, 88, 194, 29);
		panel.add(txtTitle);

		JLabel lblNewLabel_1_1_1 = new JLabel("Book Lang");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_1_1.setBounds(10, 189, 161, 29);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Book Price");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_1_2.setBounds(10, 241, 161, 29);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Book Author");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1_1_3.setBounds(10, 291, 182, 29);
		panel.add(lblNewLabel_1_1_3);

		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(191, 142, 194, 29);
		panel.add(txtSubject);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(191, 241, 194, 29);
		panel.add(txtPrice);

		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(191, 291, 194, 29);
		panel.add(txtAuthor);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(188, 411, 113, 47);
		frame.getContentPane().add(btnNewButton);


		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				bookId=txtId.getText();
				bookTitle=txtTitle.getText();
				bookSubject=txtSubject.getText();
				bookLanguage=txtLanguage.getText();
				bookPrice=txtPrice.getText();
				bookAuthor=txtAuthor.getText();
				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("INSERT INTO book(intISBN,strTitle, strSubject, strLanguage,intBookPrice,strAuthorName) VALUES(?,?,?,?,?,?)");
					pstmt.setString(1, bookId);
					pstmt.setString(2, bookTitle);
					pstmt.setString(3, bookSubject);
					pstmt.setString(4, bookLanguage);
					pstmt.setString(5, bookPrice);
					pstmt.setString(6, bookAuthor);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book Added Successfully.....");
					tableload();
					txtId.setText("");
					txtTitle.setText("");
					txtSubject.setText("");
					txtLanguage.setText("");
					txtPrice.setText("");
					txtAuthor.setText("");
					txtId.requestFocus();

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}

				);


		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(29, 411, 113, 47);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnClear = new JButton("Update");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				bookTitle=txtTitle.getText();
				bookSubject=txtSubject.getText();
				bookLanguage=txtLanguage.getText();
				bookPrice=txtPrice.getText();
				bookAuthor=txtAuthor.getText();
				bookId=txtBookId.getText();
				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("update book set strTitle=?,strSubject=?,strLanguage=?,intBookPrice=?,strAuthorName=? where intISBN=?");
					pstmt.setString(1, bookTitle);
					pstmt.setString(2, bookSubject);
					pstmt.setString(3, bookLanguage);
					pstmt.setString(4, bookPrice);
					pstmt.setString(5, bookAuthor);
					pstmt.setString(6, bookId);

					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book Updated Successfully.....");
					tableload();

					txtId.setText("");
					txtTitle.setText("");
					txtSubject.setText("");
					txtLanguage.setText("");
					txtPrice.setText("");
					txtAuthor.setText("");
					txtId.requestFocus();

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(542, 411, 113, 47);
		frame.getContentPane().add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(496, 49, 415, 322);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
				JLabel lblNewLabel = new JLabel("Softtek Library");
				scrollPane.setColumnHeaderView(lblNewLabel);
				lblNewLabel.setForeground(new Color(128, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(0, 255, 0));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(29, 469, 478, 101);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_2_1 = new JLabel("Book ID");
		lblNewLabel_1_2_1.setBounds(10, 40, 151, 32);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_1.add(lblNewLabel_1_2_1);

		txtBookId = new JTextField();
		txtBookId.setForeground(new Color(0, 0, 0));

		txtBookId.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) 
			{
				try
				{
					String bookId;
					bookId=txtBookId.getText();
					pstmt = conn.prepareStatement("select strTitle,strSubject,strLanguage,intBookPrice,strAuthorName from javaacademy.book where intISBN=?");
					pstmt.setString(1, bookId);
					ResultSet rs= pstmt.executeQuery();

					if(rs.next()==true)
					{
						String strTitle= rs.getString(1);
						String strSubject = rs.getString(2);
						String strLanguage = rs.getString(3);
						String intBookPrice=rs.getString(4);
						String strAuthorName=rs.getString(5);

						txtTitle.setText(strTitle);
						txtSubject.setText(strSubject);
						txtLanguage.setText(strLanguage);
						txtPrice.setText(intBookPrice);
						txtAuthor.setText(strAuthorName);
					}  
					else
					{
						txtTitle.setText("");
						txtSubject.setText("");
						txtLanguage.setText("");
						txtPrice.setText("");
						txtAuthor.setText("");
					}
				}
				catch (SQLException ex) 
				{

				}
			}	
			@Override
			public void keyPressed(KeyEvent e) {
			}
		}
				);
		txtBookId.setBounds(190, 40, 70, 32);
		txtBookId.setColumns(10);
		panel_1.add(txtBookId);

		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.setBackground(new Color(255, 255, 255));
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtId.setText("");
				txtTitle.setText("");
				txtSubject.setText("");
				txtLanguage.setText("");
				txtPrice.setText("");
				txtAuthor.setText("");
			}
		});
		btnClear_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnClear_1.setBounds(331, 411, 113, 47);
		frame.getContentPane().add(btnClear_1);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String bookId;
				bookId=txtBookId.getText();
				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("delete from book where intISBN=?");
					pstmt.setString(1, bookId);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted.....");
					tableload();
					txtId.setText("");
					txtTitle.setText("");
					txtSubject.setText("");
					txtLanguage.setText("");
					txtPrice.setText("");
					txtAuthor.setText("");
					txtId.requestFocus();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(692, 411, 113, 47);
		frame.getContentPane().add(btnDelete);

		JButton btnClear_1_1 = new JButton("Back");
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				optionSelection oo1=new optionSelection();
				oo1.option();
			}
		});
		btnClear_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnClear_1_1.setBackground(new Color(255, 255, 255));
		btnClear_1_1.setBounds(542, 489, 113, 47);
		frame.getContentPane().add(btnClear_1_1);

		JButton btnClear_1_1_1 = new JButton("Help");
		btnClear_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://slimkm.com/blog/faqs-about-library-management-system-islim/");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.quit();
			}
		});
		btnClear_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnClear_1_1_1.setBackground(new Color(255, 255, 255));
		btnClear_1_1_1.setBounds(692, 489, 113, 47);
		frame.getContentPane().add(btnClear_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("About Us");
		lblNewLabel_2.setToolTipText("click here");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.softtek.com/");
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.quit();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(542, 604, 146, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book Count:-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(29, 581, 195, 71);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtBookCount = new JTextField();
		txtBookCount.setToolTipText("Enter book Title");
		txtBookCount.setForeground(Color.BLACK);
		txtBookCount.setColumns(10);
		txtBookCount.setBackground(Color.WHITE);
		txtBookCount.setBounds(209, 601, 129, 43);
		frame.getContentPane().add(txtBookCount);
		
		JButton btnClear_1_1_1_1 = new JButton("Seach");
		btnClear_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bookCount();
				txtBookCount.setText("");
			}
		});
		btnClear_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnClear_1_1_1_1.setBackground(Color.WHITE);
		btnClear_1_1_1_1.setBounds(376, 595, 113, 47);
		frame.getContentPane().add(btnClear_1_1_1_1);
	}
}

