package com.ssa.service;

import java.util.List;

import com.ssa.entity.ProjectTeamRel;
import com.ssa.entity.Team;

public interface IProjectTeamRelService {
	
	List<ProjectTeamRel> getAllPTRs();
	ProjectTeamRel getProjectTeamRelById(int ptrId);
	List<Team> getAllTeamsByProjectId(int pId);
	boolean addRel(ProjectTeamRel ptr);
	void deleteRel(ProjectTeamRel ptr);
}
