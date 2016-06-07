package com.mario.dao;

import com.mario.pojo.Usuario;

public interface UsuarioDao {

	public Usuario findByUsername(String usuario);
	
}
