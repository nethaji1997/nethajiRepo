package com.softtek.ja.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class IssueBook {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtMemberId;
	private JTextField txtIssueDate;
	private JTextField txtReturnDate;
	private JTable table;
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	private static String IssuebookId,IssuememberId, issueDate, returnDate;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	
	static void deleteIssueBookFromBook() throws Exception
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
		pstmt = conn.prepareStatement("delete from book where intISBN=?");
		pstmt.setString(1, IssuebookId);
		pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "Issued book deleted from book");
	}
	public static void issue() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage.maximize();
					IssueBook window = new IssueBook();
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
	public IssueBook() {
		initialize();
	}


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
		panel.setBounds(143, 133, 657, 454);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 38, 118, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Member Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(30, 120, 118, 38);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Issue Date");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(30, 200, 118, 38);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Return Date");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(30, 284, 160, 38);
		panel.add(lblNewLabel_1_3);

		txtId = new JTextField();
		txtId.setBounds(209, 38, 132, 33);
		panel.add(txtId);
		txtId.setColumns(10);

		txtMemberId = new JTextField();
		txtMemberId.setColumns(10);
		txtMemberId.setBounds(209, 125, 132, 33);
		panel.add(txtMemberId);

		txtIssueDate = new JTextField();
		txtIssueDate.setColumns(10);
		txtIssueDate.setBounds(209, 213, 132, 33);
		panel.add(txtIssueDate);

		txtReturnDate = new JTextField();
		txtReturnDate.setColumns(10);
		txtReturnDate.setBounds(209, 284, 132, 33);
		panel.add(txtReturnDate);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				IssuebookId=txtId.getText();
				IssuememberId=txtMemberId.getText();
				issueDate=txtIssueDate.getText();
				returnDate=txtReturnDate.getText();

				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("INSERT INTO issuebook(intISBN,intMemberId, issueDate, returnDate) VALUES(?,?,?,?)");
					pstmt.setString(1, IssuebookId);
					pstmt.setString(2, IssuememberId);
					pstmt.setString(3, issueDate);
					pstmt.setString(4, returnDate);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book Issued Successfully.....");
					deleteIssueBookFromBook();
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
		btnSave.setBounds(59, 379, 104, 38);
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
		btnCancel.setBounds(221, 379, 120, 38);
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
		btnBack.setBounds(380, 379, 104, 38);
		panel.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(500, 379, 104, 38);
		panel.add(btnExit);

		JLabel lblNewLabel_2 = new JLabel("Issue Book");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(419, 79, 127, 39);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
