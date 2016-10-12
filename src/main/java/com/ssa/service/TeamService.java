package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssa.dao.ITeamDAO;
import com.ssa.entity.Team;

public class TeamService implements ITeamService {

	@Autowired
	private ITeamDAO teamDAO;

	@Override
	public List<Team> getAllTeams() {
		return teamDAO.getAllTeams();
	}

	@Override
	public Team getTeamById(int teamId) {
		return teamDAO.getTeamById(teamId);
	}

	@Override
	public boolean addTeam(Team team) {
		return teamDAO.addTeam(team);
	}

	@Override
	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	@Override
	public void deleteTeam(Team team) {
		teamDAO.deleteTeam(team);
		
	}
}
