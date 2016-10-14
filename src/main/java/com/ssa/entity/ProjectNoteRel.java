package com.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="note_project_relationship")
public class ProjectNoteRel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="note_id")
	private int note_id;
	@Column(name="project_id")
	private int project_id;
	
	public ProjectNoteRel(int id, int note_id, int project_id) {
		super();
		this.id = id;
		this.note_id = note_id;
		this.project_id = project_id;
	}
	public ProjectNoteRel(int note_id, int project_id) {
		super();
		this.note_id = note_id;
		this.project_id = project_id;
	}
	public ProjectNoteRel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	
}
