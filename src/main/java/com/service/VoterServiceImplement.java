package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Voter;
import com.repository.VoterRepository;
@Service
public class VoterServiceImplement implements VoterService {
	
	@Autowired
	 private VoterRepository voterrepo;
	
	@Override
	public Voter saveVoter(Voter voter) {
		// TODO Auto-generated method stub
		
		return voterrepo.save(voter);
		
	}
	
	@Override
	public List<Voter> voterlist() {
		// TODO Auto-generated method stub
		List<Voter> find = voterrepo.findAll();
		return find;
	}

//	@Override
//	public void deleteByid(int id) {
//		// TODO Auto-generated method stub
//	 voterrepo.deleteById(id);
//	}
	@Override
	public void deleteByid(int id) {
	    if (voterrepo.existsById(id)) {
	        voterrepo.deleteById(id);
	    } else {
	        // Handle the case where the voter with the specified ID doesn't exist
	        throw new RuntimeException("Voter with ID " + id + " not found");
	    }
	}

	@Override
	public Voter findbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Voter> findbyid = voterrepo.findById(id);
		Voter voter = findbyid.get();
		return voter;
	}

	@Override
	public Voter updatevoter(Voter voter , int id) {
		// TODO Auto-generated method stub
		Optional<Voter> voterdata = voterrepo.findById(id);
		if(voterdata.isPresent()) {
			Voter newVoter = voterdata.get();
			newVoter.setUsername(voter.getUsername());
			newVoter.setDob(voter.getDob());
			newVoter.setVoterName(voter.getVoterName());
			newVoter.setGender(voter.getGender());
			newVoter.setPassword(voter.getPassword());
			
			voterrepo.save(newVoter);
			return newVoter;
		}else {
			return null;
		}
	}
	
}
