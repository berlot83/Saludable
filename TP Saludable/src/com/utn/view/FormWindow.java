package com.utn.view;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.utn.controllers.AlertWindow;
import com.utn.controllers.TextAreaResults;
import com.utn.factory.PacientFactory;
import com.utn.model.Pacient;

public class FormWindow {

	private JFrame window;
	private JPanel topPanel, centralPanel, bottomPanel;
	private JLabel labelTitle, labelName, labelLastname, labelBirthday, labelDni, labelTelephone, labelEmail, labelCity,
			labelGenre;
	private JComboBox<String> cboGenre;
	private JTextField txtName, txtLastname, txtBirthday, txtDni, txtTelephone, txtEmail, txtCity;
	private JButton accept, buttonPacients, back;
	private Pacient pacient;

	public FormWindow() {
		window = new JFrame();
		topPanel = new JPanel();
		centralPanel = new JPanel();
		bottomPanel = new JPanel();

		window.add(topPanel, BorderLayout.NORTH);
		window.add(centralPanel, BorderLayout.CENTER);
		window.add(bottomPanel, BorderLayout.SOUTH);

		/* Separación de los inputs de los bordes */
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		centralPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

		labelTitle = new JLabel("Formulario de inscripción médica");
		topPanel.add(labelTitle);

		labelName = new JLabel("Nombre");
		txtName = new JTextField(10);

		labelLastname = new JLabel("Apellido");
		txtLastname = new JTextField(10);

		labelBirthday = new JLabel("Fecha de nac.");
		txtBirthday = new JTextField(10);

		labelDni = new JLabel("DNI");
		txtDni = new JTextField(10);

		labelTelephone = new JLabel("Teléfono");
		txtTelephone = new JTextField(10);

		labelEmail = new JLabel("Email");
		txtEmail = new JTextField(10);

		labelCity = new JLabel("Ciudad");
		txtCity = new JTextField(10);

		labelGenre = new JLabel("Género");
		String[] genre = { "Masculino", "Femenino" };
		cboGenre = new JComboBox<String>(genre);

		centralPanel.add(labelName);
		centralPanel.add(txtName);

		centralPanel.add(labelLastname);
		centralPanel.add(txtLastname);

		centralPanel.add(labelBirthday);
		centralPanel.add(txtBirthday);

		centralPanel.add(labelDni);
		centralPanel.add(txtDni);

		centralPanel.add(labelTelephone);
		centralPanel.add(txtTelephone);

		centralPanel.add(labelEmail);
		centralPanel.add(txtEmail);

		centralPanel.add(labelCity);
		centralPanel.add(txtCity);

		centralPanel.add(labelGenre);
		centralPanel.add(cboGenre);

		accept = new JButton("Aceptar");
		bottomPanel.add(accept);

		buttonPacients = new JButton("Ver Todos");
		bottomPanel.add(buttonPacients);

		/* Recupera los pacientes en una pantalla nueva */
		buttonPacients.addActionListener(event -> {
			PacientFactory pf = new PacientFactory();
			List<Pacient> pacients = pf.getPacients();
			PacientResultsWindow results = new PacientResultsWindow(pacients);
		});

		/* Boton volver */
		back = new JButton("Volver");
		bottomPanel.add(back);
		back.addActionListener(event -> window.dispose());

		/* Area de textos utilizada para resultados */
		JTextArea results = TextAreaResults.results();
		centralPanel.add(results);

		/*
		 * Creamos PacientFactory para usar metodos insertPaciente(), adherimos a un
		 * boton un Listener usando Lanmbda
		 */

		PacientFactory pf = new PacientFactory();
		accept.addActionListener(event -> {
			/*
			 * Solo el campo dni tiene restricciones o filtros en esta parte, el resto de
			 * los filtros están en PacientFactory insert.
			 * 
			 * String de validación de email tomado de http://emailregex.com/
			 */
			if (txtBirthday.getText().matches("[0-9/]+")) {
				if (txtEmail.getText().matches(
						"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
					if (txtTelephone.getText().matches("[0-9-]+")) {
						if (txtName.getText().matches("[a-zA-z]+") || txtLastname.getText().matches("[a-zA-z]+")) {
							if (txtDni.getText().equals("") || txtDni.getText().matches("[a-zA-Z]+")) {
								AlertWindow al = new AlertWindow("Completar con números el campo Dni");
							} else {

								pacient = new Pacient(txtName.getText(), txtLastname.getText().trim(),
										LocalDate.of(2001, 10, 12), Integer.parseInt(txtDni.getText()),
										txtTelephone.getText().trim(), txtEmail.getText().trim(),
										txtCity.getText().trim(), cboGenre.getSelectedItem().toString());
								/* Insertamos el paciente recién creado */
								pf.insertPacient(pacient);
								/* Lo imprimimos por la pantalla */
								results.setText("Paciente ingresado: \n");
								results.append(pacient.toString());
							}
						} else {
							AlertWindow al = new AlertWindow("Sólo letras en el campo nombre y apellido");
						}
					} else {
						AlertWindow aw = new AlertWindow("Solo numeros");
					}
				} else {
					AlertWindow aw = new AlertWindow("No es una estructura válida de un email");
				}
			} else {
				AlertWindow al = new AlertWindow("La fecha no tiene el formato correcto, que sería de la siguiente manera dd/MM/yyyy");
			}
		});

		window.setTitle("Clínica Saludable");
		window.setBounds(0, 0, 300, 600);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}
}
