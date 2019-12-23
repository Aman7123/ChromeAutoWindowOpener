package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtBoxWebsite;
	private JTextField txtBoxWindowCT;
	private JComboBox comboBox;
	
	private Users[] UserArray;
	private Users[] SelectedUsers;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI() {
		//Setup new helper
		Helper newHelper = new Helper();
		//Generate user base
		newHelper.userSetup();
		//Get Array
		UserArray = newHelper.getUserArray();
		
		setTitle("JPR Window Opener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWebsiteUrl = new JLabel("Website URL:");
		lblWebsiteUrl.setBounds(10, 11, 102, 20);
		contentPane.add(lblWebsiteUrl);
		
		JLabel lblWindowAmount = new JLabel("Window Amount:");
		lblWindowAmount.setBounds(10, 42, 102, 20);
		contentPane.add(lblWindowAmount);
		
		txtBoxWebsite = new JTextField();
		txtBoxWebsite.setBounds(110, 11, 314, 20);
		contentPane.add(txtBoxWebsite);
		txtBoxWebsite.setColumns(10);
		
		txtBoxWindowCT = new JTextField();
		txtBoxWindowCT.setBounds(110, 42, 86, 20);
		contentPane.add(txtBoxWindowCT);
		txtBoxWindowCT.setColumns(10);
		
		JLabel lblCopyright = new JLabel("Designed by Aaron - v0.0.1a");
		lblCopyright.setBounds(10, 347, 160, 14);
		contentPane.add(lblCopyright);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtBoxWebsite.getText() != "") {
					if(txtBoxWindowCT.getText() != "") {
						String website = txtBoxWebsite.getText();
						int windowAmount = Integer.parseInt(txtBoxWindowCT.getText());
						newHelper.Run(website, windowAmount);
					}
				}
			}
		});
		btnExecute.setBounds(259, 325, 89, 23);
		contentPane.add(btnExecute);
		
		comboBox = new JComboBox();
		comboBox.setBounds(110, 73, 165, 20);
		//Build Choices;
		for(Users x : UserArray) {
			comboBox.addItem(x.getProfileName());
		}
		contentPane.add(comboBox);

		JLabel lblSelectProfiles = new JLabel("Select Profiles:");
		lblSelectProfiles.setBounds(10, 73, 102, 20);
		contentPane.add(lblSelectProfiles);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println(comboBox.getSelectedItem());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(281, 73, 60, 20);
		contentPane.add(btnNewButton);
		
		JButton btnD = new JButton("Remove");
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnD.setBounds(346, 73, 78, 20);
		contentPane.add(btnD);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 104, 414, 200);
		contentPane.add(textArea);
		
		JLabel lblDirection1 = new JLabel("Select new users to create here");
		lblDirection1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDirection1.setBounds(206, 36, 218, 30);
		contentPane.add(lblDirection1);
		
		JLabel lblWindowWords = new JLabel("Total windows to launch:");
		lblWindowWords.setBounds(10, 322, 150, 14);
		contentPane.add(lblWindowWords);
		
		JLabel lblWindowTotal = new JLabel("000");
		lblWindowTotal.setBounds(170, 322, 41, 14);
		contentPane.add(lblWindowTotal);
	}
}
