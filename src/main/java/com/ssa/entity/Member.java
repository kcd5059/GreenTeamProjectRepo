package com.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")

public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="gs_grade")
	private String gs_grade;
	@Column(name="e_o_d")
	private Date e_o_d;
	@Column(name="role")
	private String role;

	public Member() {};
	public Member(int id, String first_name, String last_name, String gs_grade, Date e_o_d, String role) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gs_grade = gs_grade;
		this.e_o_d = e_o_d;
		this.role = role;
	}
	public Member(String first_name, String last_name, String gs_grade, Date e_o_d, String role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gs_grade = gs_grade;
		this.e_o_d = e_o_d;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGs_grade() {
		return gs_grade;
	}
	public void setGs_grade(String gs_grade) {
		this.gs_grade = gs_grade;
	}
	public Date getE_o_d() {
		return e_o_d;
	}
	public void setE_o_d(Date e_o_d) {
		this.e_o_d = e_o_d;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	

}
