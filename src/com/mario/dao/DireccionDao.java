package com.mario.dao;

import java.util.List;

import com.mario.pojo.Administrador;
import com.mario.pojo.Direccion;

public interface DireccionDao {
	
	public void save(Direccion direccion);
	public List<Direccion> selectAll(Administrador administrador);

}
