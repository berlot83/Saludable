package com.utn.Exceptions;

public class EmptyDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404593372818433263L;
	
	public String throwMessage() {
		return "Ningún campo puede quedar vacío, complete todo el fomulario.";
	}

}
