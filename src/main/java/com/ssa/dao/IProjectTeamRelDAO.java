package com.ssa.dao;

import java.util.List;

import com.ssa.entity.ProjectTeamRel;

public interface IProjectTeamRelDAO {
	
	List<ProjectTeamRel> getAllPTRs();
	ProjectTeamRel getProjectTeamRelById(int ptrId);
	boolean addRel(ProjectTeamRel ptr);
	void deleteRel(ProjectTeamRel ptr);

}
