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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReturnBook {

	private JFrame frame;
	public static JTextField txtId;
	private JTextField txtMemberId;
	private JTextField txtIssueDate;
	private JTable table;
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	private static String ReturnbookId,ReturnmemberId,issueDate,returnDate;
	private JTextField txtReturnDate;
	private JTextField txtMemberSearch;

	/**
	 * Launch the application.
	 */
	public static void returnbook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage.maximize();
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}
	static void deleteIssuedBook() throws Exception
	{
		String bookIdToDelete;
		bookIdToDelete=txtId.getText();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
		pstmt=conn.prepareStatement("delete from issuebook where intISBN=?");
		pstmt.setString(1, bookIdToDelete);
		pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "Record deleted from  issued book.....");	
	}
	//	static void compareDate() throws Exception
	//	{
	//		Date date1 = new Date(issueDate);
	//		Date date2 = new Date(returnDate);
	//		int result = date1.compareTo(date2);
	//
	//		if(result == 0)
	//			JOptionPane.showMessageDialog(null, "Both returned successfully");
	//		else if (result >10)
	//			JOptionPane.showMessageDialog(null, "Fine");
	//	}

	//		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	//		java.util.Date d1 = sdformat.parse(issueDate);
	//		java.util.Date d2 = sdformat.parse(returnDate);
	//		System.out.println("The date 1 is: " + sdformat.format(d1));
	//		System.out.println("The date 2 is: " + sdformat.format(d2));
	//		if(d1.compareTo(d2) > 10) 
	//		{
	//			JOptionPane.showMessageDialog(null, "As your due date is expired kindly pay the fine.....");
	//		} else if(d1.compareTo(d2) < 10) {
	//			JOptionPane.showMessageDialog(null, "Book Returned Successfully");
	//		} 
	//}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 886, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SOFTTEK LIBRARY");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(346, 11, 366, 57);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 128));
		panel.setBounds(154, 143, 623, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 38, 118, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Member Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(30, 106, 118, 38);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Issue Date");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(30, 166, 160, 38);
		panel.add(lblNewLabel_1_3);

		txtId = new JTextField();
		txtId.setBounds(209, 38, 132, 33);
		panel.add(txtId);
		txtId.setColumns(10);

		txtMemberId = new JTextField();
		txtMemberId.setColumns(10);
		txtMemberId.setBounds(209, 113, 132, 33);
		panel.add(txtMemberId);

		txtIssueDate = new JTextField();
		txtIssueDate.setColumns(10);
		txtIssueDate.setBounds(209, 173, 132, 33);
		panel.add(txtIssueDate);


		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{


				ReturnbookId=txtId.getText();
				ReturnmemberId=txtMemberId.getText();
				issueDate=txtIssueDate.getText();
				returnDate=txtReturnDate.getText();

				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("INSERT INTO returnbook(intMemberId,returnDate,intISBN,issueDate) VALUES(?,?,?,?)");
					pstmt.setString(1, ReturnmemberId);
					pstmt.setString(2, returnDate);
					pstmt.setString(3, ReturnbookId);
					pstmt.setString(4, issueDate);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book Returned Successfully....."
							+ "Thank You :) Visit Again");
					deleteIssuedBook();
					txtId.setText("");
					txtMemberId.setText("");
					txtIssueDate.setText("");
					txtReturnDate.setText("");
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(10, 319, 99, 38);
		panel.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtId.setText("");
				txtMemberId.setText("");
				txtIssueDate.setText("");
				txtReturnDate.setText("");	
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(119, 319, 111, 38);
		panel.add(btnCancel);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				optionSelection o1=new optionSelection();
				o1.option();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(391, 319, 104, 38);
		panel.add(btnBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(519, 319, 104, 38);
		panel.add(btnExit);

		JLabel lblNewLabel_1_3_1 = new JLabel("Return Date");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3_1.setBounds(30, 234, 160, 38);
		panel.add(lblNewLabel_1_3_1);

		txtReturnDate = new JTextField();
		txtReturnDate.setColumns(10);
		txtReturnDate.setBounds(209, 241, 132, 33);
		panel.add(txtReturnDate);

		JButton btnFine = new JButton("Pay Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.oreilly.com/api/v2/epubs/9781118370711/files/images/9781118370711-fg0101_fmt.png");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.quit();
			}
		});
		btnFine.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFine.setBounds(246, 319, 132, 38);
		panel.add(btnFine);

		txtMemberSearch = new JTextField();
		txtMemberSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				try
				{
					String memberId;
					memberId=txtMemberSearch.getText();
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("select intISBN,intMemberId,issueDate,returnDate from javaacademy.issuebook where intMemberId=?");
					pstmt.setString(1, memberId);
					ResultSet rs= pstmt.executeQuery();
					if(rs.next()==true)
					{
						String intISBN= rs.getString(1);
						String intMemberId = rs.getString(2);
						String issueDate= rs.getString(3);
						String returnDate=rs.getString(4);


						txtId.setText(intISBN);
						txtMemberId.setText(intMemberId);
						txtIssueDate.setText(issueDate);
						txtReturnDate.setText(returnDate);
					}  
					else
					{
						txtId.setText("");
						txtMemberId.setText("");
						txtIssueDate.setText("");
						txtReturnDate.setText("");
					}
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		txtMemberSearch.setColumns(10);
		txtMemberSearch.setBounds(445, 119, 132, 33);
		panel.add(txtMemberSearch);

		JLabel lblNewLabel_1_1_1 = new JLabel("Member Id Search");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(406, 54, 194, 38);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("Return Book");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(419, 79, 127, 39);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
