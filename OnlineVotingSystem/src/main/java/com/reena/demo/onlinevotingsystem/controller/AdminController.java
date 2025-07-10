package com.reena.demo.onlinevotingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reena.demo.onlinevotingsystem.model.Candidate;
import com.reena.demo.onlinevotingsystem.model.Voter;
import com.reena.demo.onlinevotingsystem.service.AdminService;
@CrossOrigin(origins = "*")
@RestController
	@RequestMapping("/admin")
	public class AdminController {
	    @Autowired
	    private AdminService adminService;

	    @PostMapping("/addCandidate")
	    public ResponseEntity<String> addCandidate(@RequestBody Candidate candidate) {
	        return ResponseEntity.ok(adminService.addCandidate(candidate));
	    }

	    @GetMapping("/candidates")
	    public ResponseEntity<List<Candidate>> getCandidates() {
	        return ResponseEntity.ok(adminService.getAllCandidates());
	    }

	    @GetMapping("/voters")
	    public ResponseEntity<List<Voter>> getVoters() {
	        return ResponseEntity.ok(adminService.getAllVoters());
	    }
	}

