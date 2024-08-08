package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Admin;
import com.repository.AdminRepository;
import com.service.AdminService;
import com.service.AdminServiceImplement;

import jakarta.validation.Valid;


@Controller
public class AdminController {
	
	@Autowired
	AdminRepository adminrepository;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/")
	public String adminRegisterpage() {
		return "dashboard";
	}
	
	@GetMapping("/adminregister")
	public String saveAdmin(Model model) {
		model.addAttribute("admin", new Admin());
		return "adminregister";
	}

//	@PostMapping("/administ")
//	public String getAdminStatus(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "adminregister";
//		}
//		adminService.saveAdmin(admin);
//		return "adminlogin";
//	}

	
	 @PostMapping("/administ")
	    public String getAdminStatus(@Valid @ModelAttribute Admin admin, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
	        if (bindingResult.hasErrors()) {
	            return "adminregister";
	        }
	        adminService.saveAdmin(admin);
	        redirectAttributes.addFlashAttribute("successMessage", "Admin registered successfully!");
	        return "redirect:/adminregister";
	}
	 
	 @GetMapping("/adminlist")
		public String getAdminsList(Model model) {
		    model.addAttribute("admins", adminService.adminlist());
		    return "adminlist";
		}
}
