package com.reena.demo.onlinevotingsystem.model;

	import jakarta.persistence.*;

	@Entity
	public class Vote {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "voter_id", nullable = false)
	    private Voter voter;

	    @ManyToOne
	    @JoinColumn(name = "candidate_id", nullable = false)
	    private Candidate candidate;
	     
	   public Vote() {
	    }
	    
	    public Vote(Long id, Voter voter, Candidate candidate) {
			super();
			this.id = id;
			this.voter = voter;
			this.candidate = candidate;
		}

		@Override
		public String toString() {
			return "Vote [id=" + id + ", voter=" + voter + ", candidate=" + candidate + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Voter getVoter() {
			return voter;
		}

		public void setVoter(Voter voter) {
			this.voter = voter;
		}

		public Candidate getCandidate() {
			return candidate;
		}

		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
	    

	    
	}


