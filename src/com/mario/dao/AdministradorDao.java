package com.mario.dao;

import java.util.List;

import com.mario.pojo.Administrador;

public interface AdministradorDao {

	public void save(Administrador administrador); 
	public List<Administrador> selectAll();
	public Administrador findById(int id);
	public List<Administrador> findByNombre(String nombre);
	public void update(Administrador administrador);
	public void delete(int idAd);	
	
}
