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

import com.ssa.entity.Note;
import com.ssa.entity.ProjectNoteRel;
import com.ssa.service.IProjectNoteRelService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProjectNoteRelController {

	@Autowired
	private IProjectNoteRelService pnrService;

	@RequestMapping(value = "/projectnoterels", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectNoteRel>> getAllPNRs() {
		List<ProjectNoteRel> pnrs = pnrService.getAllPNRs();
		return new ResponseEntity<List<ProjectNoteRel>>(pnrs, HttpStatus.OK);
	}
	
	// Get list of notes given a projectId
	@RequestMapping(value = "/getprojectnotes/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getAllNotesByProjectId(@PathVariable("pid") Integer pId) {
		List<Note> notes = pnrService.getAllNotesByProjectId(pId);
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteprojectnoterel/{id}", method = RequestMethod.DELETE)
	public void deleteRel(@PathVariable("id") Integer id) {
		ProjectNoteRel pnr = pnrService.getProjectNoteRelById(id);
		pnrService.deleteRel(pnr);
	}
	
	@RequestMapping(value="/projectnoterel", method = RequestMethod.POST)
	public ResponseEntity<Void> addRel(@RequestBody ProjectNoteRel pnr) {
		pnrService.addRel(pnr);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
