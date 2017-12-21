package com.utn.model;

public class Food {

	private String priorityMeal;
	private String secondaryMeal;
	private String mealSelected;
	private String dessert;
	private String hungry;
	private String namePacientAssigned;
	
	public Food(String priorityMeal, String secondaryMeal, String mealSelected, String dessert, String hungry) {
		super();
		this.priorityMeal = priorityMeal;
		this.secondaryMeal = secondaryMeal;
		this.mealSelected = mealSelected;
		this.dessert = dessert;
		this.hungry = hungry;
	}
	
	public Food(String priorityMeal, String secondaryMeal, String mealSelected, String dessert, String hungry,
			String namePacientAssigned) {
		super();
		this.priorityMeal = priorityMeal;
		this.secondaryMeal = secondaryMeal;
		this.mealSelected = mealSelected;
		this.dessert = dessert;
		this.hungry = hungry;
		this.namePacientAssigned = namePacientAssigned;
	}
	
	public String getPriorityMeal() {
		return priorityMeal;
	}

	public void setPriorityMeal(String priorityMeal) {
		this.priorityMeal = priorityMeal;
	}

	public String getSecondaryMeal() {
		return secondaryMeal;
	}

	public void setSecondaryMeal(String secondaryMeal) {
		this.secondaryMeal = secondaryMeal;
	}

	public String isDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String isHungry() {
		return hungry;
	}

	public void setHungry(String hungry) {
		this.hungry = hungry;
	}

	public String getMealSelected() {
		return mealSelected;
	}

	public void setMealSelected(String mealSelected) {
		this.mealSelected = mealSelected;
	}

	public String getNamePacientAssigned() {
		return namePacientAssigned;
	}

	public void setNamePacientAssigned(String namePacientAssigned) {
		this.namePacientAssigned = namePacientAssigned;
	}

	@Override
	public String toString() {
		return "Comida asiganada a "+namePacientAssigned+"   Principal=" + priorityMeal + ",   secundaria=" + secondaryMeal + ",   comida seleccionada="
				+ mealSelected + ",   postre=" + dessert + ",   Quedó con hambre=" + hungry;
	}

}
