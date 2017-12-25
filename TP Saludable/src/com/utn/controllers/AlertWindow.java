package com.utn.controllers;

import javax.swing.JOptionPane;

public class AlertWindow {
	
	public AlertWindow(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public AlertWindow(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
}
