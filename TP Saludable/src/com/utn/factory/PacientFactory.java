package com.utn.factory;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.utn.Exceptions.EmptyDataException;
import com.utn.controllers.AlertWindow;
import com.utn.controllers.BackupOnFile;
import com.utn.dao.IConnection;
import com.utn.dao.IMethodsDataBase;
import com.utn.model.Pacient;
import com.utn.view.LoginWindow;

public class PacientFactory implements IMethodsDataBase<Pacient> {

	private IConnection connex;

	public PacientFactory() {
		this.connex = new ConnectionFactory();
	}

	@Override
	public Pacient getPacient(int id) {

		Pacient pacient = null;

		try {

			Statement st = connex.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pacient WHERE id = " + id);

			while (rs.next()) {
				pacient = new Pacient(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"),
						rs.getDate("birthday").toLocalDate(), rs.getInt("dni"), rs.getString("telephone"),
						rs.getString("email"), rs.getString("city"), rs.getString("genre"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return pacient;
	}

	@Override
	public List<Pacient> getPacients() {

		List<Pacient> list = new ArrayList<>();
		try {
			Statement st = connex.getConnection().createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id, name, lastname, birthday, dni, telephone, email, city, genre FROM pacient");

			while (rs.next()) {
				list.add(new Pacient(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"),
						rs.getDate("birthday").toLocalDate(), rs.getInt("dni"), rs.getString("telephone"),
						rs.getString("email"), rs.getString("city"), rs.getString("genre")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertPacient(Pacient pacient) {

		Period periodAge = Period.between(pacient.getBirthday(), LocalDate.now());
		int age = periodAge.getYears();

		String name = pacient.getName();
		String lastname = pacient.getLastname();
		int dni = pacient.getDni();
		String telephone = pacient.getTelephone();
		String email = pacient.getEmail();
		String city = pacient.getCity();
		String genre = pacient.getGenre();

		if (name.equals("") || lastname.equals("") || dni <= 0 || age <= 0 || telephone.equals("") || city.equals("")
				|| email.equals("") || genre.equals("")) {
			EmptyDataException empty = new EmptyDataException();
			AlertWindow aw = new AlertWindow(empty.throwMessage());
		} else {
			try {
				String sql = "INSERT INTO pacient(name, lastname, birthday, dni, age, telephone, email, city, genre) VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connex.getConnection().prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, lastname);
				ps.setDate(3, java.sql.Date.valueOf(pacient.getBirthday()));
				ps.setInt(4, protectionNumberException(dni));
				ps.setInt(5, age);
				ps.setString(6, telephone);
				ps.setString(7, email);
				ps.setString(8, city);
				ps.setString(9, genre);
				ps.executeUpdate();
				System.out.println("Data Updated");

				/* Backup en txt */
				BackupOnFile.saveLog(pacient.toString(), pacient.getName());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private int protectionNumberException(int number) {
		try {
			return number;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
