package com.lazaro.onetomany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 private String username;
	 
	 @NotNull 
	 private String email;
	 
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")	    
	 private Date createdAt;
	 
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;

	 
	 public User() {}
	 
	// ------------------ ONE-TO-MANY ---------------
	 @OneToMany(mappedBy="donor", fetch = FetchType.LAZY)
	  private List<Donation> donations;
	 
	 
	 
	 public List<Donation> getDonations() {
		return donations;
	}



	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public String getUsername() {
		return username;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	@PrePersist
	 protected void onCreate(){
		 this.createdAt = new Date();
	 }
	   
	 @PreUpdate
     protected void onUpdate(){
		 this.updatedAt = new Date();
	 }	
}
