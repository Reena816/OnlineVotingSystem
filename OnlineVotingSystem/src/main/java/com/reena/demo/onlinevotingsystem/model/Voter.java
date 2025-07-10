package com.reena.demo.onlinevotingsystem.model;


	import jakarta.persistence.*;

	@Entity
	public class Voter {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(unique = true)
	    private String username;
	    private String password;
	    private boolean hasVoted;
	    public Voter() {
	    }
		public Voter(Long id, String username, String password, boolean hasVoted) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.hasVoted = hasVoted;
		}
		@Override
		public String toString() {
			return "Voter [id=" + id + ", username=" + username + ", password=" + password + ", hasVoted=" + hasVoted
					+ "]";
		}
         
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isHasVoted() {
			return hasVoted;
		}
		public void setHasVoted(boolean hasVoted) {
			this.hasVoted = hasVoted;
		}
	}


