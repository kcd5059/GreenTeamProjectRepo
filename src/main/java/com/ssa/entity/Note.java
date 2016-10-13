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
	
	// Constructors
	public Note() {};
	public Note(int id, String message, Date time_stamp) {
		this.id = id;
		this.message = message;
		this.time_stamp = time_stamp;
	}
	public Note(String message, Date time_stamp) {
		this.message = message;
		this.time_stamp = time_stamp;
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
	
	

}
