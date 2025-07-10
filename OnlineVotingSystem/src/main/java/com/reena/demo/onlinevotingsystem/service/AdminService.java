package com.reena.demo.onlinevotingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.demo.onlinevotingsystem.model.Candidate;
import com.reena.demo.onlinevotingsystem.model.Voter;
import com.reena.demo.onlinevotingsystem.repository.CandidateRepository;
import com.reena.demo.onlinevotingsystem.repository.VoterRepository;

@Service
	public class AdminService {
	    @Autowired
	    private CandidateRepository candidateRepo;

	    @Autowired
	    private VoterRepository voterRepo;

	    public String addCandidate(Candidate candidate) {
	        candidate.setVoteCount(0);
	        candidateRepo.save(candidate);
	        return "Candidate added successfully!";
	    }

	    public List<Candidate> getAllCandidates() {
	        return candidateRepo.findAll();
	    }

	    public List<Voter> getAllVoters() {
	        return voterRepo.findAll();
	    }
	}


