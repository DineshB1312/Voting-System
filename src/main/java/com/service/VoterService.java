package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Voter;

@Service
public interface VoterService {
	public Voter saveVoter(Voter voter);
	public List<Voter>voterlist();
	public void deleteByid(int id);
	public Voter findbyid(int id);
	public Voter updatevoter(Voter voter, int id);
}
