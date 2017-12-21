package com.utn.factory;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import com.utn.dao.IConnection;
import com.utn.dao.IMethodsDataBase;
import com.utn.model.Pacient;
import com.utn.view.AlertWindow;

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
						rs.getDate("birthday").toLocalDate(), rs.getInt("dni"),
						rs.getString("telephone"), rs.getString("email"), rs.getString("city"), rs.getString("genre"));
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
			ResultSet rs = st.executeQuery("SELECT id, name, lastname, birthday, dni, telephone, email, city, genre FROM pacient");

			while (rs.next()) {
				list.add(new Pacient(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"),
						rs.getDate("birthday").toLocalDate(), rs.getInt("dni"),
						rs.getString("telephone"), rs.getString("email"), rs.getString("city"), rs.getString("genre")));
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
		
		try {
			String sql = "INSERT INTO pacient(name, lastname, birthday, dni, age, telephone, email, city, genre) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connex.getConnection().prepareStatement(sql);
			ps.setString(1, pacient.getName());
			ps.setString(2, pacient.getLastname());
			ps.setDate(3, java.sql.Date.valueOf(pacient.getBirthday()));
			ps.setInt(4, pacient.getDni());
			ps.setInt(5, age);
			ps.setString(6, pacient.getTelephone());
			ps.setString(7, pacient.getEmail());
			ps.setString(8, pacient.getCity());
			ps.setString(9, pacient.getGenre());
			ps.executeUpdate();
			System.out.println("Data Updated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//Pacient p1 = new Pacient(1,"Axel", "Berlot", LocalDate.of(1983,04,9), 30158619, "1553189339", "berlot83@yahoo.com.ar", "Buenos Aires", "Masculino");
		PacientFactory pf = new PacientFactory();
		//pf.insertPacient(p1);
		
		
		for(Pacient item : pf.getPacients()) {
	//		System.out.println(item.toString());
		}
		
		System.out.println(pf.getPacient(13));
	}

}
