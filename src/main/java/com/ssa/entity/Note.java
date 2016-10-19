package com.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="note")
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="message")
	private String message;
	@Column(name="time_stamp")
	private Date time_stamp;
	@Column(name="project_id")
	private int project_id;
	
	// Constructors
	public Note() {
		super();
	}
	public Note(String message, Date time_stamp, int project_id) {
		super();
		this.message = message;
		this.time_stamp = time_stamp;
		this.project_id = project_id;
	}
	public Note(int id, String message, Date time_stamp, int project_id) {
		super();
		this.id = id;
		this.message = message;
		this.time_stamp = time_stamp;
		this.project_id = project_id;
	}

	// Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	

}
