package com.utn.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

public class BackupOnFile implements Serializable{
	/**
	 * Copia en los datos ingresados en un archivo en el path principal del proyecto
	 */
	private static final long serialVersionUID = 208438101929954252L;
	
	static public void saveLog(String report, String name) {
		try {
			/* Local del proyecto */
			File fileLocal = new File("BackupFolderPacients/"+name+".txt");
			if(fileLocal.exists()) {
				AlertWindow aw = new AlertWindow("El archivo para esta consulta ya existe y no puede sobreescribirse, verifique si igualmente los datos se cargaron en la DB");
			}else{
				FileWriter fileWriterLocal = new FileWriter(fileLocal, true);
				fileWriterLocal.write(report);
				fileWriterLocal.flush();
				fileWriterLocal.close(); 				
			}
		} catch (Exception error) {
			System.out.println("explotó : "+ error.getMessage());
		}
	}
	
	static public void saveLogFood(String report, String name) {
		try {
			/* Local del proyecto */
			File fileLocal = new File("BackupFolderMeals/"+name+".txt");
			if(fileLocal.exists()) {
				AlertWindow aw = new AlertWindow("El archivo para esta consulta ya existe y no puede sobreescribirse, verifique si igualmente los datos se cargaron en la DB");
			}else{
				FileWriter fileWriterLocal = new FileWriter(fileLocal, true);
				fileWriterLocal.write(report);
				fileWriterLocal.flush();
				fileWriterLocal.close(); 				
			}
		} catch (Exception error) {
			System.out.println("explotó : "+ error.getMessage());
		}
	}

}
