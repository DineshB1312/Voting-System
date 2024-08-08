package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Admin;
@Service
public interface AdminService {
	public void saveAdmin(Admin admin);
	public List<Admin> adminlist();
	 
}
