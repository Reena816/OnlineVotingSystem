package com.reena.demo.onlinevotingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.demo.onlinevotingsystem.model.Voter;
import com.reena.demo.onlinevotingsystem.repository.VoterRepository;

@Service
	public class VoterService {
	    @Autowired
	    private VoterRepository voterRepository;

	    public String registerVoter(Voter voter) {
	    	Optional<Voter> existingVoter = voterRepository.findByUsername(voter.getUsername());

	        if (existingVoter.isPresent()) {
	            return "Username already exists!";
	    	 }
	        voter.setHasVoted(false);
	        voterRepository.save(voter);
	        return "Voter registered successfully!";
//	        Voter savedVoter = voterRepository.save(voter); 
//	        return "Voter registered successfully! ID: " + savedVoter.getId(); 
	    }

	    public String loginVoter(String username, String password) {
	        return voterRepository.findByUsername(username)
	            .filter(v -> v.getPassword().equals(password))
	            .map(v -> "Login successful!")
	            .orElse("Invalid credentials");
	    }
	}



