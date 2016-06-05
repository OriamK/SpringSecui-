package com.mario.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdministradorRowMapper implements RowMapper<Administrador>{

	@Override
	public Administrador mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Administrador administrador = new Administrador();
		
		administrador.setIdAd(rs.getInt("idAd"));
		administrador.setCargo(rs.getString("cargo"));
		administrador.setNombre(rs.getString("nombre"));
		administrador.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		
		return administrador;
	}

}
