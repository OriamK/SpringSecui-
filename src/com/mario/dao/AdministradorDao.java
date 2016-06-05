package com.mario.dao;

import java.util.List;

import com.mario.pojo.Administrador;

public interface AdministradorDao {

	public boolean save(Administrador administrador); 
	public List<Administrador> selectAll();
	public Administrador findById(int id);
	public List<Administrador> findByNombre(String nombre);
	public boolean update(Administrador administrador);
	public boolean delete(int idAd);
	public int[] saveAll(List<Administrador> administradors);
	
	
}
