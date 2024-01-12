package com.techstudy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TechStudyEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//@NotEmpty(message="Course name Should not be null")
	private String courseName;
	public TechStudyEntity() {
		super();
	}
	public TechStudyEntity(String courseName, String url) {
		super();
		this.courseName = courseName;
		this.url = url;
	}
	
	//@NotEmpty(message="Url should not be null")
	private String url;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
