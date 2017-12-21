package com.utn.model;

import java.time.LocalDate;

public class Pacient extends Person {


	private String traitment;
	
	public Pacient() {
		super();
	}

	public Pacient(int id, String name, String lastname, LocalDate birthday, int dni, String telephone,
			String email, String city, String genre) {
		super(id, name, lastname, birthday, dni, telephone, email, city, genre);
	}
	
	public Pacient(String name, String lastname, LocalDate birthday, int dni, String telephone, String email,
			String city, String genre) {
		super(name, lastname, birthday, dni, telephone, email, city, genre);
	}

	
	public String getTraitment() {
		return traitment;
	}

	public void setTraitment(String traitment) {
		this.traitment = traitment;
	}

	@Override
	public String toString() {
		return "Pacient id= "+getId()+ ", Nombre= "+getName()+", Apellido="+getLastname()+", Dni= "+getDni();
	}
	
	
}