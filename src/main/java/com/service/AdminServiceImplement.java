package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.repository.AdminRepository;

@Service
public class AdminServiceImplement  implements AdminService{
	
	@Autowired
	private AdminRepository adminrepo;

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminrepo.save(admin);
	}

	@Override
	public List<Admin> adminlist() {
		// TODO Auto-generated method stub
		List<Admin> find = adminrepo.findAll();
		return find;
	}
	
	
}
