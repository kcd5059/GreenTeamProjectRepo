package com.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team_project_relationship")
public class ProjectTeamRel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="project_id")
	private int project_id;
	@Column(name="team_id")
	private int team_id;
	public ProjectTeamRel(int id, int project_id, int team_id) {
		super();
		this.id = id;
		this.project_id = project_id;
		this.team_id = team_id;
	}
	public ProjectTeamRel(int project_id, int team_id) {
		super();
		this.project_id = project_id;
		this.team_id = team_id;
	}
	public ProjectTeamRel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
}
