package com.utn.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.utn.factory.UserFactory;

public class RegisterWindow {
	
	private JFrame window;
	private JPanel topPanel, centralPanel, bottomPanel;
	private JLabel title, user, password;
	private JTextField txtUser, txtPassword;
	private JButton accept, back;
	
	public RegisterWindow() {
		
		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();
		window = new JFrame();
		topPanel = new JPanel();
		window.setLayout(new BorderLayout());
		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);
		
		title = new JLabel("Registro de usuario");
		user = new JLabel("Usuario");
		password = new JLabel("Password");
		txtUser = new JTextField(10);
		txtPassword = new JTextField(10);
		
		topPanel.add(title);
		centralPanel.add(user);
		centralPanel.add(txtUser);
		centralPanel.add(password);
		centralPanel.add(txtPassword);
		
		accept = new JButton("Registrarse");
		back = new JButton("Cancelar");
		
		bottomPanel.add(accept);
		bottomPanel.add(back);
		
		window.setTitle("Registro");
		window.setBounds(0, 0, 230, 200);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		accept.addActionListener(event ->{
			try{
				UserFactory uf = new UserFactory();
			
			uf.registerUser(txtUser.getText(), txtPassword.getText());
			}catch(Exception error) {
				AlertWindow aw = new AlertWindow("Probablemente ése nombre de usuario ya exista");
			}
		});
		
		back.addActionListener(event -> window.dispose());
	}
	
}
