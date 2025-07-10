package com.reena.demo.onlinevotingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reena.demo.onlinevotingsystem.model.Candidate;
import com.reena.demo.onlinevotingsystem.service.VoteService;
@CrossOrigin(origins = "*")
@RestController
	@RequestMapping("/vote")
	public class VoteController {
	    @Autowired
	    private VoteService voteService;

	    @PostMapping("/cast")
	    public ResponseEntity<String> castVote(@RequestParam Long voterId, @RequestParam Long candidateId) {
	        return ResponseEntity.ok(voteService.castVote(voterId, candidateId));
	    }

	    @GetMapping("/results")
	    public ResponseEntity<List<Candidate>> getResults() {
	        return ResponseEntity.ok(voteService.getResults());
	    }
	}


