package com.utn.controllers;

import java.awt.Color;

import javax.swing.JTextArea;

public class TextAreaResults {
	
	public static JTextArea results() {
		
		JTextArea results = new JTextArea(10,5);
		results.setEditable(false);
		results.setBackground(Color.DARK_GRAY);
		results.setForeground(Color.green);
		
		return results;
		
	}

}
