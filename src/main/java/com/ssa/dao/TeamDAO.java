package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Team;

@Transactional
@Repository
public class TeamDAO implements ITeamDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getAllTeams() {
		String hql = "FROM Team as t ORDER BY t.id";
		return (List<Team>) hibernateTemplate.find(hql);
	}

	@Override
	public Team getTeamById(int teamId) {
		return (Team) hibernateTemplate.get(Team.class, teamId);
	}

	@Override
	public boolean addTeam(Team team) {
		int result = (int) hibernateTemplate.save(team);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateTeam(Team team) {
		Team record = getTeamById(team.getId());
		record.setDescription(team.getDescription());
		record.setMember_id(team.getMember_id());
		hibernateTemplate.update(record);
	}

	@Override
	public void deleteTeam(Team team) {
		Team dbTeam = getTeamById(team.getId());
		hibernateTemplate.delete(dbTeam);
	}

}
