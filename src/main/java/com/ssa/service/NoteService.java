package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.INoteDAO;
import com.ssa.entity.Note;

@Service
public class NoteService implements INoteService {
	
	@Autowired
	private INoteDAO noteDAO;

	@Override
	public List<Note> getAllNotes() {
		return noteDAO.getAllNotes();
	}

	@Override
	public Note getNoteById(int noteId) {
		return noteDAO.getNoteById(noteId);
	}
	
	@Override
	public List<Note> getNotesByProjectId(int projectId) {
		return noteDAO.getNotesByProjectId(projectId);
	}

	@Override
	public boolean addNote(Note note) {
		return noteDAO.addNote(note);
	}

	@Override
	public void updateNote(Note note) {
		noteDAO.updateNote(note);
	}

	@Override
	public void deleteNote(Note note) {
		noteDAO.deleteNote(note);
		
	}
}
