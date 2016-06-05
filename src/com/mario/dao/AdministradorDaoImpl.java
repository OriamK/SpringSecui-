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

@Component("adminDao")
public class AdministradorDaoImpl implements AdministradorDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Administrador administrador) {

		// MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// paramMap.addValue("nombre", administrador.getNombre());
		// paramMap.addValue("cargo", administrador.getCargo());
		// paramMap.addValue("fechaCreacion", administrador.getFechaCreacion());

		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(
				administrador);

		return jdbcTemplate
				.update("insert into administrador(nombre,cargo,fechaCreacion) values(:nombre,:cargo,:fechaCreacion)",
						paramMap) == 1;
	}

	@Override
	public List<Administrador> selectAll() {

		return jdbcTemplate.query("select * from administrador",
				new AdministradorRowMapper());
	}

	@Override
	public Administrador findById(int id) {

		// return (Administrador)
		// jdbcTemplate.query("select * from administrador where idAd=:idAd",new
		// MapSqlParameterSource("idAd",id), new AdministradorRowMapper());
		return (Administrador) jdbcTemplate.queryForObject(
				"select * from administrador where idAd=:idAd",
				new MapSqlParameterSource("idAd", id),
				new AdministradorRowMapper());
	}

	@Override
	public List<Administrador> findByNombre(String nombre) {

		return jdbcTemplate.query(
				"select * from administrador where nombre like :nombre",
				new MapSqlParameterSource("nombre", "%" + nombre + "%"),
				new AdministradorRowMapper());
	}

	@Override
	public boolean update(Administrador administrador) {

		return jdbcTemplate
				.update("update administrador set nombre=:nombre,cargo=:cargo,fechaCreacion=:fechaCreacion where idAd=:idAd",
						new BeanPropertySqlParameterSource(administrador)) == 1;
	}

	@Override
	public boolean delete(int idAd) {

		return jdbcTemplate.update(
				"delete from administrador where idAd=:idAd",
				new MapSqlParameterSource("idAd", idAd)) == 1;
	}

	@Transactional
	@Override
	public int[] saveAll(List<Administrador> administradors) {

		SqlParameterSource[] batchArgs = SqlParameterSourceUtils
				.createBatch(administradors.toArray());

		return jdbcTemplate
				.batchUpdate(
						"insert into administrador(idAd,nombre,cargo,fechaCreacion) values(:idAd,:nombre,:cargo,:fechaCreacion)",
						batchArgs);

	}
}
