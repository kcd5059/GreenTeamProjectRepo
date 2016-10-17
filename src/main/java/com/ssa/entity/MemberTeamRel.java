package com.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_team_relationship")
public class MemberTeamRel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="member_id")
	private int member_id;
	@Column(name="team_id")
	private int team_id;
	
	public MemberTeamRel(int id, int member_id, int team_id) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.team_id = team_id;
	}

	public MemberTeamRel(int member_id, int team_id) {
		super();
		this.member_id = member_id;
		this.team_id = team_id;
	}

	public MemberTeamRel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
}
