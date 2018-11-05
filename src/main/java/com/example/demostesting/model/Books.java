package com.example.demostesting.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String title;
	private String description;
	@ManyToOne(cascade = CascadeType.PERSIST)

	private Authors author;
	/*
	@ManyToMany
	private List<Reviewers> reviewers;
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}
/*
	public List<Reviewers> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewers> reviewers) {
		this.reviewers = reviewers;
	}*/
	
	
}
