package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.entity.AdminLogin;
import com.service.AdminService;



@Controller
public class AdminLoginController {
	@Autowired
	AdminService adminService;
	

	@GetMapping("/adminlogin")
	public String getadminlogin(Model model) {
		model.addAttribute("adminlogin", new AdminLogin());
		return "adminlogin";
	}
}
