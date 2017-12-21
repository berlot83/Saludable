package com.utn.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.utn.factory.UserFactory;

public class LoginWindow {

	private JFrame window;
	private JPanel topPanel, centralPanel, bottomPanel;
	private JLabel title, labelUser, labelPassword;
	private JTextField txtUser, txtPassword;
	private JButton login;
	private JButton register;

	public LoginWindow() {
		window = new JFrame();
		window.setLayout(new BorderLayout());

		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();
		login = new JButton("Login");

		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);

		title = new JLabel("Ingrese credenciales");
		topPanel.add(title);

		labelUser = new JLabel("Usuario");
		txtUser = new JTextField(15);

		labelPassword = new JLabel("Password");
		txtPassword = new JTextField(15);

		centralPanel.add(labelUser);
		centralPanel.add(txtUser);

		centralPanel.add(labelPassword);
		centralPanel.add(txtPassword);

		bottomPanel.add(login);

		/* Login user */
		login.addActionListener(event -> {
			UserFactory uf = new UserFactory();
			if (uf.verifyUser(txtUser.getText(), txtPassword.getText())) {

				JLabel greetings = new JLabel("Logueado");
				Runnable run = () -> {
					centralPanel.add(greetings);

					try {
						Thread.sleep(500);
						greetings.setForeground(Color.red);
						Thread.sleep(400);
						greetings.setForeground(Color.blue);
						Thread.sleep(300);
						greetings.setForeground(Color.green);
						Thread.sleep(400);
						greetings.setForeground(Color.magenta);
						Thread.sleep(500);
						greetings.setForeground(Color.orange);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				};
				/* Corremos ése objeto */
				run.run();
				FormWindow frm = new FormWindow();
			} else {
				AlertWindow aw = new AlertWindow("Credenciales incorrectas");
			}
		});

		/* Boton registrarse */
		register = new JButton("Registrarse");
		register.addActionListener(event -> {
			RegisterWindow rw = new RegisterWindow();
		});

		bottomPanel.add(register);

		window.setTitle("TP Saludable");
		window.setBounds(0, 0, 230, 300);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
