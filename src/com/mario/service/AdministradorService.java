package com.mario.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.dao.AdministradorDao;
import com.mario.pojo.Administrador;


@Service
public class AdministradorService {
	
	
	@Autowired
	private AdministradorDao administradorDao;
	
	public boolean save(Administrador administrador) {
		
		administrador.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		return administradorDao.save(administrador);
	}
	
	public List<Administrador> selectAll() {
		
		return administradorDao.selectAll();
	}

	public Administrador findById(int id) {
		
		return administradorDao.findById(id);
	}
	

}
