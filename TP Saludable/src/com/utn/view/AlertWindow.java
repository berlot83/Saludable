package com.utn.view;

import javax.swing.JOptionPane;

public class AlertWindow {
	private JOptionPane alert;
	
	public AlertWindow(String message) {
		alert = new JOptionPane();
		alert.showMessageDialog(null, message);
	}

}
