package com.ssa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ssa.entity.Project;
import com.ssa.service.IProjectService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProjectController {
	
	@Autowired
	private IProjectService projectService;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProjectById(@PathVariable("id") Integer id) {
		Project project = projectService.getProjectById(id);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable("id") Integer id) {
		Project project = projectService.getProjectById(id);
		projectService.deleteProject(project);
	}

	
	@RequestMapping(value="/project", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProject(@RequestBody Project project) {
		projectService.updateProject(project);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value="/project", method = RequestMethod.POST)
	public ResponseEntity<Void> addProject(@RequestBody Project project) {
		projectService.addProject(project);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
