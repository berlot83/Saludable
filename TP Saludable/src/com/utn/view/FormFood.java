package com.utn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.utn.model.Pacient;
import com.utn.factory.FoodFactory;
import com.utn.factory.PacientFactory;

public class FormFood {

	private JFrame window;
	private JPanel topPanel, centralPanel, bottomPanel;
	private JLabel title, pacient, priorityFood, secondaryFood, mealSelected, dessert, hungry, labelResults;
	private JTextField txtPriorityFood, txtSecondaryFood;
	private String[] meal = { "Desayuno", "Almuerzo", "Merienda", "Cena" };
	private JComboBox<String> cboPacient, cboMealSelected, cboDessert, cboHungry;
	private JButton accept, back;
	private List<Pacient> pacients = new ArrayList<>();

	public FormFood() {
		window = new JFrame();
		window.setLayout(new BorderLayout());

		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();

		txtPriorityFood = new JTextField(10);
		txtSecondaryFood = new JTextField(10);

		/* Traemos los datos de la DB */
		PacientFactory df = new PacientFactory();

		/* inicializamos el objeto List<Pacient> */
		pacients = df.getPacients();

		/*
		 * Creamos un String[] vacío indicando que va a tener la misma cantidad de
		 * lugares que la List<Pacient>
		 */
		String[] arrayPacients = new String[pacients.size()];

		/*
		 * Iteramos sobre la List<Pacient> y vamos asignando a cada array vacio un valor
		 * del getName()
		 */
		for (int i = 0; i < pacients.size(); i++) {
			arrayPacients[i] = pacients.get(i).getName();
		}

		/* Adherimos ése array al JComboBox */
		cboPacient = new JComboBox<String>(arrayPacients);

		/* El array de este combo esta determinado arriba */
		cboMealSelected = new JComboBox<String>(meal);
		cboDessert = new JComboBox<String>(new String[] { "si", "no" });
		cboHungry = new JComboBox<String>(new String[] { "si", "no" });

		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);
		
		/* Separación de los inputs de los bordes */
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		centralPanel.setBorder(new EmptyBorder(15,15,15,15));

		title = new JLabel("Formulario de comidas");
		topPanel.add(title);

		pacient = new JLabel("Elija el paciente");
		centralPanel.add(pacient);
		centralPanel.add(cboPacient);

		priorityFood = new JLabel("Comida principal");
		centralPanel.add(priorityFood);
		centralPanel.add(txtPriorityFood);

		secondaryFood = new JLabel("Comida secundaria");
		centralPanel.add(secondaryFood);
		centralPanel.add(txtSecondaryFood);

		mealSelected = new JLabel("Comida del Dia");
		centralPanel.add(mealSelected);
		centralPanel.add(cboMealSelected);

		dessert = new JLabel("Postre");
		centralPanel.add(dessert);
		centralPanel.add(cboDessert);

		hungry = new JLabel("Se quedó con hambre?");
		centralPanel.add(hungry);
		centralPanel.add(cboHungry);

		/* Creamos el label del resultado */
		labelResults = new JLabel("Horario del pedido");
		centralPanel.add(labelResults);
		
		accept = new JButton("Enviar");
		bottomPanel.add(accept);
		accept.addActionListener(event -> {
			FoodFactory ff = new FoodFactory();
			ff.insertFood(txtPriorityFood.getText(), txtSecondaryFood.getText(),
					cboMealSelected.getSelectedItem().toString(), cboDessert.getSelectedItem().toString(),
					cboHungry.getSelectedItem().toString(), cboPacient.getSelectedItem().toString());
			
			/* Cambiamos el color al resultado del Horario */
			labelResults.setForeground(Color.BLUE);
			labelResults.setText(LocalDateTime.now().toString());
		});
		
		back = new JButton("Volver");
		bottomPanel.add(back);
		back.addActionListener(event -> window.dispose());

		window.setTitle("Comidas");
		window.setBounds(0, 0, 250, 400);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}

}
