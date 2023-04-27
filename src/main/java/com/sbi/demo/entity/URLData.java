package com.sbi.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class URLData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String fullUrlName;
	private String shortUrlName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfullUrlName() {
		return fullUrlName;
	}
	public void setfullUrlName(String fullUrlName) {
		this.fullUrlName = fullUrlName;
	}
	public String getshortUrlName() {
		return shortUrlName;
	}
	public void setshortUrlName(String shortUrlName) {
		this.shortUrlName = shortUrlName;
	}

}
