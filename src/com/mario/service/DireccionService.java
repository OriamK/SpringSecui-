package com.mario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.dao.AdministradorDao;
import com.mario.dao.DireccionDao;
import com.mario.pojo.Administrador;
import com.mario.pojo.Direccion;

@Service
public class DireccionService {

	@Autowired
	private AdministradorDao administradorDao;
	@Autowired
	private DireccionDao direccionDao;
	
	public void save(Administrador administrador, Direccion direccion) {
		
		direccion.setAdministrador(administrador);
		direccionDao.save(direccion);
	}
	
	public List<Direccion> selectAll(int idAd) {
		
		Administrador administrador = administradorDao.findById(idAd);
		
		return direccionDao.selectAll(administrador);
	}
	
	
}
