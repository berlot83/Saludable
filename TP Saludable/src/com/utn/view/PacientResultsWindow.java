package com.utn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.utn.model.Pacient;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PacientResultsWindow {
	
	private JFrame window;
	private JPanel topPanel, centralPanel, bottomPanel;
	private JLabel title;
	private JTextArea results;
	private JButton  back;
	
	public PacientResultsWindow(List<Pacient> pacients) {
		window = new JFrame();
		window.setLayout(new BorderLayout());
		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();
		
		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);
		
		title = new JLabel("Todos los pacientes en DB");
		title.setForeground(Color.BLUE);
		
		topPanel.add(title);
		
		results = new JTextArea(20,20);
		results.setBackground(Color.DARK_GRAY);
		results.setForeground(Color.GREEN);
		
		/* Agregamos todos los resultados de la DB al JTextArea */
		for (Pacient pacient : pacients) {
			results.append(pacient.toString()+"\n");
		}
		
		/* Agrgegamos el JTextArea */
		centralPanel.add(results);
		
		/* Volver */
		back = new JButton("Volver");
		bottomPanel.add(back);
		back.addActionListener(event -> window.dispose());
		
		/* Visualizador de ventana */
		window.setTitle("Pacientes");
		window.setBounds(0, 0, 350, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
