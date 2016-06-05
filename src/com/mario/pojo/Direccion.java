package com.mario.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Direccion {

	private String calle;
	private String codigo;
	
	public Direccion() {
		
	}

	public Direccion(String calle, String codigo) {
		super();
		this.calle = calle;
		this.codigo = codigo;
	}

	@Autowired
	public void setCalle(@Value("VES")String calle) {
		this.calle = calle;
	}
	
	@Autowired
	public void setCodigo(@Value("14")String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", codigo=" + codigo + "]";
	}
	
	
	
}
