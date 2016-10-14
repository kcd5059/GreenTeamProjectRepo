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
import com.ssa.entity.ProjectTeamRel;
import com.ssa.service.IProjectTeamRelService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProjectTeamRelController {

	@Autowired
	private IProjectTeamRelService ptrService;

	@RequestMapping(value = "/projectteamrels", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectTeamRel>> getAllPTRs() {
		List<ProjectTeamRel> ptrs = ptrService.getAllPTRs();
		return new ResponseEntity<List<ProjectTeamRel>>(ptrs, HttpStatus.OK);
	}

	@RequestMapping(value = "/projectteamrel/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProjectTeamRel> getProjectTeamRelById(@PathVariable("id") Integer id) {
		ProjectTeamRel ptr = ptrService.getProjectTeamRelById(id);
		return new ResponseEntity<ProjectTeamRel>(ptr, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteprojectteamrel/{id}", method = RequestMethod.DELETE)
	public void deleteRel(@PathVariable("id") Integer id) {
		ProjectTeamRel ptr = ptrService.getProjectTeamRelById(id);
		ptrService.deleteRel(ptr);
	}
	
	@RequestMapping(value="/projectteamrel", method = RequestMethod.POST)
	public ResponseEntity<Void> addRel(@RequestBody ProjectTeamRel ptr) {
		ptrService.addRel(ptr);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
