package com.mario.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mario.pojo.Administrador;
import com.mario.pojo.Direccion;
import com.mario.service.AdministradorService;
import com.mario.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private DireccionService direccionService;

	@RequestMapping("/direccion/{idAd}")
	public String getAll(Model model,@ModelAttribute("resultado")String resultado,
			@PathVariable("idAd") int idAd) {

		Administrador admin = administradorService.findById(idAd);
		model.addAttribute("admin", admin);
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("resultado", resultado);
		
		model.addAttribute("direcciones", direccionService.selectAll(idAd));
		
		return "direccion";
	}
	
	@RequestMapping("/direccion/save")
	public String save(Model model,RedirectAttributes ra,
			@ModelAttribute("direccion")Direccion direccion,
			@ModelAttribute("admin")Administrador administrador) {
		
		direccionService.save(administrador, direccion);
		ra.addFlashAttribute("resultado", "Cambios realizados con exito");
		
		return "redirect:/direccion/"+administrador.getIdAd();
	}
	
	
	
	

}
