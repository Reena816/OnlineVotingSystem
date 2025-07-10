package com.reena.demo.onlinevotingsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.reena.demo.onlinevotingsystem.model.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {
	 

}
