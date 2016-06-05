package com.mario.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mario.pojo.Administrador;
import com.mario.pojo.AdministradorRowMapper;


public class AdministradorDaoImpl implements AdministradorDao {

	@Override
	public void save(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrador> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idAd) {
		// TODO Auto-generated method stub
		
	}

	
}
