package com.utn.Exceptions;

public class EmptyDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404593372818433263L;
	
	public String throwMessage() {
		return "Ning�n campo puede quedar vac�o, complete todo el fomulario.";
	}

}
