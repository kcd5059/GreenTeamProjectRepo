//package com.ssa.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="note")
//public class Note {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//	@Column(name="message")
//	private String message;
//	@Column(name="submitted")
//	private Date submitted;
//	
//	// Constructors
//	public Note() {};
//	public Note(int id, String message, Date submitted) {
//		this.id = id;
//		this.message = message;
//		this.submitted = submitted;
//	}
//	public Note(String message, Date submitted) {
//		this.message = message;
//		this.submitted = submitted;
//	}
//	
//	// Methods
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	public Date getSubmitted() {
//		return submitted;
//	}
//	public void setSubmitted(Date submitted) {
//		this.submitted = submitted;
//	}
//
//}
