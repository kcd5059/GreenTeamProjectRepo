package com.ssa.service;

import java.util.List;
import com.ssa.entity.Note;

public interface INoteService {
	
	List<Note> getAllNotes();
	Note getNoteById(int noteId);
	boolean addNote(Note note);
	void updateNote(Note note);
	void deleteNote(Note note);
	List<Note> getNotesByProjectId(int projectId);
}
