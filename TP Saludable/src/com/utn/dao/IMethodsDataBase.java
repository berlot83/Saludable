package com.utn.dao;

import java.sql.SQLException;
import java.util.List;

import com.utn.model.Pacient;

public interface IMethodsDataBase<T extends Pacient> {

	public List<T> getPacients();

	public void insertPacient(T tobject);

	T getPacient(int id);

}
