package com.twg.springboot.mydiary.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entries")
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entrydate;
	
	private String description;
	
	private long userid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	
	

}
