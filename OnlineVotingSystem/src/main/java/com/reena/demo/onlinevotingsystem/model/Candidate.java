package com.reena.demo.onlinevotingsystem.model;


	import jakarta.persistence.*;

	@Entity
	public class Candidate {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private int voteCount;

	    public Candidate(Long id, String name, int voteCount) {
	        this.id = id;
	        this.name = name;
	        this.voteCount = voteCount;
	    }

	    public Candidate() {
	        
	    }

		@Override
		public String toString() {
			return "Candidate [id=" + id + ", name=" + name + ", voteCount=" + voteCount + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getVoteCount() {
			return voteCount;
		}

		public void setVoteCount(int voteCount) {
			this.voteCount = voteCount;
		}
	    

	}


