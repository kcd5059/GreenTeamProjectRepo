package com.ssa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssa.dao.IProjectTeamRelDAO;
import com.ssa.entity.ProjectTeamRel;
import com.ssa.entity.Team;

@Service
public class ProjectTeamRelService implements IProjectTeamRelService {

	@Autowired
	private IProjectTeamRelDAO ptrDAO;
	
	@Override
	public List<ProjectTeamRel> getAllPTRs() {
		return ptrDAO.getAllPTRs();
	}

	@Override
	public ProjectTeamRel getProjectTeamRelById(int ptrId) {
		return ptrDAO.getProjectTeamRelById(ptrId);
	}

	@Override
	public boolean addRel(ProjectTeamRel ptr) {
		return ptrDAO.addRel(ptr);
	}

	@Override
	public void deleteRel(ProjectTeamRel ptr) {
		ptrDAO.deleteRel(ptr);
		
	}

	@Override
	public List<Team> getAllTeamsByProjectId(int pId) {
		return ptrDAO.getAllTeamsByProjectId(pId);
	}
	
}
