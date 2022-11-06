package com.softtek.ja.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class optionSelection 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void option() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage.maximize();
					optionSelection window = new optionSelection();
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
	public optionSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(188, 254, 218));
		frame.setBounds(100, 100, 864, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SOFTTEK LIBRARY");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(297, 61, 333, 53);
		frame.getContentPane().add(lblNewLabel);

		JRadioButton rdbtnMemberOperation = new JRadioButton("Member Operation");
		rdbtnMemberOperation.setBackground(new Color(255, 128, 0));
		rdbtnMemberOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Member m1=new Member();
				m1.member();
			}
		});
		rdbtnMemberOperation.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnMemberOperation.setBounds(178, 309, 250, 73);
		frame.getContentPane().add(rdbtnMemberOperation);

		JRadioButton rdbtnIssueBook = new JRadioButton("Issue Book");
		rdbtnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				IssueBook i1=new IssueBook();
				i1.issue();

			}
		});
		rdbtnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnIssueBook.setBackground(new Color(255, 128, 0));
		rdbtnIssueBook.setBounds(476, 194, 250, 73);
		frame.getContentPane().add(rdbtnIssueBook);

		JRadioButton rdbtnReturnBook = new JRadioButton("Return Book");
		rdbtnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ReturnBook r1=new ReturnBook();
				r1.returnbook();
			}
		});
		rdbtnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnReturnBook.setBackground(new Color(255, 128, 0));
		rdbtnReturnBook.setBounds(476, 309, 250, 73);
		frame.getContentPane().add(rdbtnReturnBook);

		JRadioButton rdbtnBookOperation = new JRadioButton("Book Operation");
		rdbtnBookOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Book b1=new Book();
				b1.book();
				
			}
		});
		rdbtnBookOperation.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnBookOperation.setBackground(new Color(255, 128, 0));
		rdbtnBookOperation.setBounds(178, 194, 250, 73);
		frame.getContentPane().add(rdbtnBookOperation);
		
		JRadioButton rdbtnExit = new JRadioButton("Exit");
		rdbtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		rdbtnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnExit.setBackground(new Color(255, 128, 0));
		rdbtnExit.setBounds(178, 410, 250, 73);
		frame.getContentPane().add(rdbtnExit);
	}

	void methodOption()
	{
		option();
	}
}
