package com.utn.factory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.utn.dao.IConnection;
import com.utn.model.User;
import com.utn.view.AlertWindow;

public class UserFactory {

	private IConnection connex;

	public UserFactory() {
		this.connex = new ConnectionFactory();
	}

	/* Login a manopla */
	public boolean verifyUser(String strUser, String strPassword) {
		boolean isLoged = false;
		User user = null;

		/*
		 * Traemos los datos y los metemos en un user, mala practica buscar entre todos,
		 * debería buscar un user en especial y luego ahi hacer la comparación pero
		 * estoy sin tiempo
		 */
		try {
			Statement st = connex.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("user"), rs.getString("password"));
				System.out.println(user.getUser());
				System.out.println(user.getPassword());

				/* Comparamos los datos del user con los colocados en los input */
				if (strUser.equals(user.getUser()) && strPassword.equals(user.getPassword())) {
					isLoged = true;
					System.out.println("Access granted");
				} else {
					System.out.println("Access denied");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isLoged;
	}
	
	/* Método para registrar users, si estan vacíos los input tira mensaje */
	public void registerUser(String user, String password) {
		
		try {if(user.equals("") || password.equals("")) {
			AlertWindow aw = new AlertWindow("Debe ingresar algun dato");
		}else {
			String sql = "INSERT INTO user(user, password)  VALUES(?,?)";
			PreparedStatement ps = connex.getConnection().prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("Data updated");
		}

		}catch(Exception error) {
			System.out.println(error.getMessage());
			AlertWindow aw = new AlertWindow("Probablemente ya haya un usuario con ése nombre");
		}
		
	}

}
