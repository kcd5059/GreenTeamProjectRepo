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
import com.ssa.service.INoteService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class NoteController {
	
	@Autowired
	private INoteService noteService;
	
	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getAllNotes() {
		List<Note> notes = noteService.getAllNotes();
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}

	@RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
	public ResponseEntity<Note> getNoteById(@PathVariable("id") Integer id) {
		Note note = noteService.getNoteById(id);
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notes/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getNotesByProjectId(@PathVariable("pid") Integer projectId) {
		List<Note> notes = noteService.getNotesByProjectId(projectId);
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletenote/{id}", method = RequestMethod.DELETE)
	public void deleteNote(@PathVariable("id") Integer id) {
		Note note = noteService.getNoteById(id);
		noteService.deleteNote(note);
	}

	
	@RequestMapping(value="/updatenote", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateNote(@RequestBody Note note) {
		noteService.updateNote(note);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value="/note", method = RequestMethod.POST)
	public ResponseEntity<Void> addNote(@RequestBody Note note) {
		noteService.addNote(note);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
