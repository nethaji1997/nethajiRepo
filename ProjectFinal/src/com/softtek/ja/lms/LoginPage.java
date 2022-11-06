package com.softtek.ja.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class LoginPage extends JFrame{

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}


	public static void maximize() {
		JFrame frame = new JFrame("Window Title");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//		frame.setVisible(true);
		//		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 215, 174));
		frame.setBackground(new Color(128, 255, 255));
		frame.setForeground(new Color(255, 128, 0));
		frame.getContentPane().setForeground(new Color(255, 128, 0));
		frame.setBounds(100, 100, 896, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SOFTTEK LIBRARAY");
		lblNewLabel.setBounds(389, 0, 372, 121);
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setBackground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(216, 149, 666, 436);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel txtPassword = new JLabel("PASSWORD");
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword.setBounds(78, 221, 183, 56);
		panel.add(txtPassword);

		textUsername = new JTextField();
		textUsername.setToolTipText("username");
		textUsername.setBounds(295, 153, 175, 31);
		panel.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JTextField();
		textPassword.setToolTipText("password");
		textPassword.setColumns(10);
		textPassword.setBounds(295, 238, 175, 31);
		panel.add(textPassword);

		

		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				String username="nethaji";
				String password="abc1234";
				String inputUsername=textUsername.getText();
				String regex="[a-zA-Z]+\\.?";
				if(inputUsername.matches(regex))
				{

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username");
				}
				String inputPassword=textPassword.getText();
				if(username.equalsIgnoreCase(inputUsername) && password.equals(inputPassword))
				{
					JOptionPane.showMessageDialog(null, "Login Successfull");
					maximize();
					optionSelection o1=new optionSelection();
					o1.methodOption();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Username and Password");		
				}

			}
		});
		
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginButton.setBounds(184, 317, 89, 40);
		panel.add(loginButton);

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textUsername.setText("");
				textPassword.setText("");
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelButton.setBounds(420, 317, 105, 40);
		panel.add(cancelButton);

		JLabel txtUsername = new JLabel("USERNAME");
		txtUsername.setBounds(78, 136, 183, 56);
		panel.add(txtUsername);
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("LIBRARIAN LOGIN");
		lblNewLabel_1.setBounds(175, 11, 372, 84);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel lblNewLabel_2 = new JLabel("Follow  Us:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(31, 389, 118, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Facebook");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com/softtek");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.close();
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(184, 396, 77, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Twitter");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://twitter.com/Softtek");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.close();
			}
		});
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(294, 396, 77, 14);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Instagram");
		lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.instagram.com/softtekofficial/");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.quit();
			}
		});
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(381, 396, 89, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Contact Us");
		lblNewLabel_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Softtek Library Contact Details:- \n"
						+ "Monday To Saturday (9AM to 6 PM) \n"
						+ "Email: team-2@softteklibrary.com, "
						+ "Contact number: 9964423857 \n"
						+ "Address:- Shilpa Emerald, 26/1 Hosur Main Road, Bangalore, Karnataka, India 560068.");
			}
		});
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(498, 398, 89, 14);
		panel.add(lblNewLabel_3_1_1_1);

	}

}

