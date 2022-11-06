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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.proteanit.sql.DbUtils;

public class Member {

	private JFrame frame;
	private JTextField txtMemberId;
	private JTextField txtMemberName;
	private JTextField txtMemberMobile;
	private JTextField txtMemberEmail;
	private JTable table;
	private JTextField txtMemberSearchId;
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	static String memberId,memberName,memberMobile,memberEmail;

	/**
	 * Launch the application.
	 */
	public static void member() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage.maximize();
					Member window = new Member();
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
	public Member() {
		initialize();
		tableload();
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
			pstmt = conn.prepareStatement("Select * from member");
		} catch (SQLException e) 
		{
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
		frame.setBounds(100, 100, 903, 755);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SOFTTEK LIBRARY");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(382, 11, 374, 81);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 223, 191));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Adding Member", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 119, 336, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Member Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 56, 129, 55);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(21, 128, 147, 55);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mobile");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(21, 202, 129, 55);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(21, 275, 129, 55);
		panel.add(lblNewLabel_1_2_1);

		txtMemberId = new JTextField();
		txtMemberId.setBounds(196, 77, 96, 34);
		panel.add(txtMemberId);
		txtMemberId.setColumns(10);

		txtMemberName = new JTextField();
		txtMemberName.setColumns(10);
		txtMemberName.setBounds(196, 149, 129, 34);
		panel.add(txtMemberName);

		txtMemberMobile = new JTextField();
		txtMemberMobile.setColumns(10);
		txtMemberMobile.setBounds(196, 211, 129, 34);
		panel.add(txtMemberMobile);

		txtMemberEmail = new JTextField();
		txtMemberEmail.setColumns(10);
		txtMemberEmail.setBounds(196, 289, 129, 34);
		panel.add(txtMemberEmail);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(382, 141, 89, 48);
		frame.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtMemberId.setText("");
				txtMemberName.setText("");
				txtMemberMobile.setText("");
				txtMemberEmail.setText("");
				txtMemberId.requestFocus();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(382, 237, 89, 42);
		frame.getContentPane().add(btnClear);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				memberId=txtMemberId.getText();
				memberName=txtMemberName.getText();
				memberMobile=txtMemberMobile.getText();
				memberEmail=txtMemberEmail.getText();
				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("INSERT INTO member(intMemberId,strMemberName, memberMblNo, memberEmail) VALUES(?,?,?,?)");
					pstmt.setString(1, memberId);
					pstmt.setString(2, memberName);
					pstmt.setString(3, memberMobile);
					pstmt.setString(4, memberEmail);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Thank you for being a member of Softtek Library....."
							+ "Kindly Pay 500/- Rs as a deposit");
					tableload();
					txtMemberId.setText("");
					txtMemberName.setText("");
					txtMemberMobile.setText("");
					txtMemberEmail.setText("");
					txtMemberId.requestFocus();

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(382, 328, 89, 48);
		frame.getContentPane().add(btnNewButton_2);

		table = new JTable();
		table.setBounds(556, 141, 323, 322);
		frame.getContentPane().add(table);

		JButton btnNewButton_2_1 = new JButton("Update");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				memberId=txtMemberSearchId.getText();
				memberName=txtMemberName.getText();
				memberMobile=txtMemberMobile.getText();
				memberEmail=txtMemberEmail.getText();
				try 
				{
					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("update member set strMemberName=?,memberMblNo=?,memberEmail=? where intMemberId=?");
					pstmt.setString(1, memberName);
					pstmt.setString(2, memberMobile);
					pstmt.setString(3, memberEmail);
					pstmt.setString(4, memberId);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Member Updated Successfully.....");

					tableload();
					txtMemberId.setText("");
					txtMemberName.setText("");
					txtMemberMobile.setText("");
					txtMemberEmail.setText("");
					txtMemberId.requestFocus();

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}

		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(633, 501, 112, 48);
		frame.getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Delete");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String memberId;
				memberId=txtMemberSearchId.getText();
				try 
				{

					conn = DriverManager.getConnection("jdbc:mysql://localhost/javaacademy", "root", "Softtek@2022");	
					pstmt = conn.prepareStatement("delete from member where intMemberId=?");
					pstmt.setString(1, memberId);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted.....");
					tableload();
					txtMemberId.setText("");
					txtMemberName.setText("");
					txtMemberMobile.setText("");
					txtMemberEmail.setText("");
					txtMemberId.requestFocus();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_2.setBounds(776, 501, 103, 48);
		frame.getContentPane().add(btnNewButton_2_2);

		JLabel lblNewLabel_2 = new JLabel("Search Member");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(35, 542, 180, 25);
		frame.getContentPane().add(lblNewLabel_2);

		txtMemberSearchId = new JTextField();
		txtMemberSearchId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				try 
				{
					String memberSearchId;
					memberSearchId=txtMemberSearchId.getText();
					pstmt = conn.prepareStatement("select strMemberName,memberMblNo,memberEmail from member where intMemberId=?");
					pstmt.setString(1, memberSearchId);
					ResultSet rs= pstmt.executeQuery();
					if(rs.next()==true)
					{
						String strMemberName= rs.getString(1);
						String memberMblNo = rs.getString(2);
						String memberEmail = rs.getString(3);



						txtMemberName.setText(strMemberName);
						txtMemberMobile.setText(memberMblNo);
						txtMemberEmail.setText(memberEmail);

					}  
					else
					{
						txtMemberName.setText("");
						txtMemberMobile.setText("");
						txtMemberEmail.setText("");

					}
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		txtMemberSearchId.setBounds(59, 589, 96, 34);
		frame.getContentPane().add(txtMemberSearchId);
		txtMemberSearchId.setColumns(10);
		
		JButton btnNewButton_2_1_1 = new JButton("Back");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				optionSelection oo2=new optionSelection();
				oo2.option();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1_1.setBounds(495, 501, 112, 48);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JButton Help = new JButton("Help");
		Help.addActionListener(new ActionListener() {
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
		Help.setFont(new Font("Tahoma", Font.BOLD, 20));
		Help.setBounds(382, 428, 89, 48);
		frame.getContentPane().add(Help);
	}
}
