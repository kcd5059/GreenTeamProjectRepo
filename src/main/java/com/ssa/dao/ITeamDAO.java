package com.ssa.dao;

import java.util.List;

import com.ssa.entity.Team;

public interface ITeamDAO {
	
	List<Team> getAllTeams();
	Team getTeamById(int teamId);
	boolean addTeam(Team team);
	void updateTeam(Team team);
	void deleteTeam(Team team);

}
