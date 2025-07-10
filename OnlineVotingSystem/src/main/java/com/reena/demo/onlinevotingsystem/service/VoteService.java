package com.reena.demo.onlinevotingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.demo.onlinevotingsystem.model.Candidate;
import com.reena.demo.onlinevotingsystem.model.Vote;
import com.reena.demo.onlinevotingsystem.model.Voter;
import com.reena.demo.onlinevotingsystem.repository.CandidateRepository;
import com.reena.demo.onlinevotingsystem.repository.VoteRepository;
import com.reena.demo.onlinevotingsystem.repository.VoterRepository;

@Service
	public class VoteService {
	    @Autowired
	    private VoterRepository voterRepo;

	    @Autowired
	    private CandidateRepository candidateRepo;

	    @Autowired
	    private VoteRepository voteRepo;

	    public String castVote(Long voterId, Long candidateId) {
	        Voter voter = voterRepo.findById(voterId).orElse(null);
	        if (voter == null || voter.isHasVoted()) {
	            return "Voter not found or already voted";
	        }
	        Candidate candidate = candidateRepo.findById(candidateId).orElse(null);
	        if (candidate == null) return "Candidate not found";

	        Vote vote = new Vote();
	        vote.setVoter(voter);
	        vote.setCandidate(candidate);
	        voteRepo.save(vote);

	        candidate.setVoteCount(candidate.getVoteCount() + 1);
	        candidateRepo.save(candidate);

	        voter.setHasVoted(true);
	        voterRepo.save(voter);

	        return "Vote cast successfully";
	    }

	    public List<Candidate> getResults() {
	        return candidateRepo.findAll();
	    }
	}

	
