package com.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mario.pojo.Administrador;


@Controller
public class AdminController {

	
	@RequestMapping("/admin")
	public String showAdmin(Model model,@ModelAttribute("resultado") String resultado) {
		
		Administrador admin = new Administrador();
		
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		
		return "admin";
	}
	
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm,
			Model model, RedirectAttributes ra, @RequestParam("estado") String estado) {
		
		System.out.println(adminForm);
		System.out.println("requet param: "+estado);
		
		ra.addFlashAttribute("resultado", "Cambios realizados con exito");
		
		return "redirect:/admin";
		
	}
	
}
