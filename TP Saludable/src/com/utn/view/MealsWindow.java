package com.utn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import com.utn.factory.FoodFactory;
import com.utn.model.Food;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MealsWindow {
	
	private JFrame window;
	private JPanel topPanel;
	private JLabel title;
	private JPanel centralPanel;
	private JPanel bottomPanel;
	private JTextArea results;
	private JButton back;
	private List<Food> listMeals;
 	
	public MealsWindow() {
		window = new JFrame();
		window.setLayout(new BorderLayout());
		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();
		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);
		
		title = new JLabel("Comidas Asignadas a pacientes");
		topPanel.add(title);
		
		results = new JTextArea(20,20);
		results.setBackground(Color.DARK_GRAY);
		results.setForeground(Color.green);
		centralPanel.add(results);
		/* Boton volver */
		back = new JButton("Volver");
		bottomPanel.add(back);
		back.addActionListener(event -> window.dispose());
		
		/* Creamos la lista */
		listMeals = new ArrayList<>();
		
		/* Traemos los resultados de la DB */
		FoodFactory ff = new FoodFactory();
		listMeals = ff.getFoods();
		
		/* Iteramos los elementos y los adherimos al JTextArea */
		for (Food item : listMeals) {
			results.append(item.toString()+"\n");
		}
		
		window.setTitle("Comidas Asignadas");
		window.setLocationRelativeTo(null);
		window.setBounds(0,0,780,400);
		window.setVisible(true);
	}
	
}
