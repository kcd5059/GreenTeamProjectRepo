package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IProjectDAO;
import com.ssa.entity.Project;


@Service
public class ProjectService implements IProjectService {

	@Autowired
	private IProjectDAO projectDAO;

	@Override
	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	@Override
	public Project getProjectById(int projectId) {
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public boolean addProject(Project project) {
		return projectDAO.addProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectDAO.deleteProject(project);
		
	}
}
