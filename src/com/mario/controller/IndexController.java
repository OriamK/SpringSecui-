package com.mario.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
//@SessionAttributes({"resultado","mensaje"})
@SessionAttributes("resultado")
public class IndexController {
	
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		
		model.addAttribute("resultado", "resultado de session");
		
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		return "about";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "/";
	}
	
	
	
}
