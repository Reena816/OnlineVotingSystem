package com.reena.demo.onlinevotingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reena.demo.onlinevotingsystem.model.Voter;
import com.reena.demo.onlinevotingsystem.service.VoterService;
@CrossOrigin(origins = "*")
@RestController
	@RequestMapping("/auth")
	public class AuthController {
	    @Autowired
	    private VoterService voterService;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody Voter voter) {
	        return ResponseEntity.ok(voterService.registerVoter(voter));
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Voter voter) {
	        return ResponseEntity.ok(voterService.loginVoter(voter.getUsername(), voter.getPassword()));
	    }
	}


