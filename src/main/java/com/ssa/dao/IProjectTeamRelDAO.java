package com.ssa.dao;

import java.util.List;

import com.ssa.entity.ProjectTeamRel;
import com.ssa.entity.Team;

public interface IProjectTeamRelDAO {
	
	List<ProjectTeamRel> getAllPTRs();
	List<Team> getAllTeamsByProjectId(int pId);
	ProjectTeamRel getProjectTeamRelById(int ptrId);
	boolean addRel(ProjectTeamRel ptr);
	void deleteRel(ProjectTeamRel ptr);

}
