package com.utn.model;

import java.time.LocalDate;

public abstract class Person {

	private int id;
	private String name;
	private String lastname;
	private LocalDate birthday;
	private int dni;
	private int age;
	private String telephone;
	private String email;
	private String city;
	private String genre;
	
	public Person() {
		
	}

	public Person(int id,String name, String lastname, LocalDate birthday, int dni, String telephone, String email,
			String city, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
		this.dni = dni;
		this.telephone = telephone;
		this.email = email;
		this.city = city;
		this.genre = genre;
	}
	
	public Person(String name, String lastname, LocalDate birthday, int dni, String telephone, String email,
			String city, String genre) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
		this.dni = dni;
		this.telephone = telephone;
		this.email = email;
		this.city = city;
		this.genre = genre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday + ", dni="
				+ dni + ", age=" + age + ", telephone=" + telephone + ", email=" + email + ", city=" + city + ", genre="
				+ genre + "]";
	}

}