package com.reena.demo.onlinevotingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reena.demo.onlinevotingsystem.model.Voter;

public interface VoterRepository extends JpaRepository<Voter,Long> {
	Optional<Voter> findByUsername(String username);

}
