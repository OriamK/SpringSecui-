package com.mario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mario.pojo.Administrador;
import com.mario.service.AdministradorService;


@Controller
public class AdminController {

	@Autowired
	private AdministradorService administradorService;
	
	
	@RequestMapping("/admin")
	public String showAdmin(Model model,@ModelAttribute("resultado") String resultado) {
		
		Administrador admin = new Administrador();
		
		List<Administrador> administradors = administradorService.selectAll();
		
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		model.addAttribute("administradores", administradors);
		
		return "admin";
	}
	
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm,
			Model model, RedirectAttributes ra) {
		
		if(administradorService.save(adminForm)) {
			ra.addFlashAttribute("resultado", "Cambios realizados con exito");
		} else {
			ra.addFlashAttribute("resultado", "Error al grabar");
		}
		
		return "redirect:/admin";		
	}
	

	@RequestMapping("admin/{idAd}/update")
	public String showUpdate(Model model, @PathVariable("idAd") int id) {
		
		Administrador admin = administradorService.findById(id);
		model.addAttribute("admin", admin);
		
		return "admin";
	}
	
}
