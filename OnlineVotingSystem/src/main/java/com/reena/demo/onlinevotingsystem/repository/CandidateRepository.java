package com.reena.demo.onlinevotingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reena.demo.onlinevotingsystem.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

}
