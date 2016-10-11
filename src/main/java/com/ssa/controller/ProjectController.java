package com.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ssa.service.IProjectService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProjectController {
	
	@Autowired
	private IProjectService projectService;

}
