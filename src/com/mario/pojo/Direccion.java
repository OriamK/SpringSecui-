package com.mario.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Entity
@Table(name="direccion")
public class Direccion {

	@Id
	@GeneratedValue
	private int idDir;
	private String calle;
	private String codigo;
	
	
	@ManyToOne
	@JoinColumn(name="idAd") //nombre de la clave foranea
	private Administrador administrador;
	
	public Direccion() {
		
	}

	public Direccion(String calle, String codigo) {
		super();
		this.calle = calle;
		this.codigo = codigo;
	}

	public int getIdDir() {
		return idDir;
	}

	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "Direccion [idDir=" + idDir + ", calle=" + calle + ", codigo="
				+ codigo + "]";
	}

	
	
	
}
