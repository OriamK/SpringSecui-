package com.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.dao.UsuarioDao;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
}
