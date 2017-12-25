package com.utn.factory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utn.Exceptions.EmptyDataException;
import com.utn.controllers.AlertWindow;
import com.utn.controllers.BackupOnFile;
import com.utn.dao.IConnection;
import com.utn.model.Food;

public class FoodFactory {

	private IConnection connex;

	public FoodFactory() {
		this.connex = new ConnectionFactory();
	}

	public void insertFood(String priorityFood, String secondaryFood, String mealSelected, String dessert, String hungry, String namePacient) {
		try {
			if(priorityFood.equals("") || secondaryFood.equals("") || mealSelected.equals("") || dessert.equals("") || hungry.equals("") || namePacient.equals("")) {
				EmptyDataException e = new EmptyDataException();
				AlertWindow aw = new AlertWindow(e.throwMessage());
			}else {
				
				String sql = "INSERT INTO food(priority_food, secondary_food, meal_selected, dessert, hungry, name_pacient) VALUES(?,?,?,?,?,?)";
				PreparedStatement  ps = connex.getConnection().prepareStatement(sql);
				ps.setString(1, priorityFood);
				ps.setString(2, secondaryFood);
				ps.setString(3, mealSelected);
				ps.setString(4, dessert);
				ps.setString(5, hungry);
				ps.setString(6, namePacient);
				ps.executeUpdate();
				System.out.println("Data executed");
				
				BackupOnFile bof = new BackupOnFile();
				/* No uso toString porque no pasé un paciento como parámetro */
				bof.saveLogFood("El paciente "+namePacient+", comida principal: "+priorityFood+", comida secundaria= "+secondaryFood, namePacient);
				
			}
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	
	
	public List<Food> getFoods() {

		List<Food> list = new ArrayList<>();
		try {
			Statement st = connex.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT priority_food, secondary_food, meal_selected, dessert, hungry, name_pacient FROM food");

			while (rs.next()) {
				list.add(new Food(rs.getString("priority_food"), rs.getString("secondary_food"), rs.getString("meal_selected"),
						rs.getString("dessert"), rs.getString("hungry"), rs.getString("name_pacient")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

}
