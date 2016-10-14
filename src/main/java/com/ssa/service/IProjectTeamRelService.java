package com.ssa.service;

import java.util.List;

import com.ssa.entity.ProjectTeamRel;

public interface IProjectTeamRelService {
	
	List<ProjectTeamRel> getAllPTRs();
	ProjectTeamRel getProjectTeamRelById(int ptrId);
	boolean addRel(ProjectTeamRel ptr);
	void deleteRel(ProjectTeamRel ptr);
}
