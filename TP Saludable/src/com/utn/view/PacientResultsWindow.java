package com.utn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
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
	private JButton  back, mealSchedule;
	
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
		
		/* Ventana de comidas */
		mealSchedule = new JButton("Declarar comidas");
		bottomPanel.add(mealSchedule);
		mealSchedule.addActionListener(event ->{
			FormFood ff = new FormFood();
		});
		
		/* Volver */
		back = new JButton("Volver");
		bottomPanel.add(back);
		back.addActionListener(event -> window.dispose());
		
		JButton viewAllMeals = new JButton("Ver comidas");
		bottomPanel.add(viewAllMeals);
		viewAllMeals.addActionListener(event -> {
			MealsWindow mw = new MealsWindow();
		});
		
		/* Visualizador de ventana */
		window.setTitle("Pacientes");
		window.setBounds(0, 0, 400, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
