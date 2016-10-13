package com.ssa.dao;

import java.util.List;

import com.ssa.entity.Project;

public interface IProjectDAO {
	
	List<Project> getAllProjects();
	Project getProjectById(int projectId);
	boolean addProject(Project project);
	void updateProject(Project project);
	void deleteProject(Project project);
}
