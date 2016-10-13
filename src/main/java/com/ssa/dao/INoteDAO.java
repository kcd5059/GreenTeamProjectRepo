package com.ssa.dao;

import java.util.List;

import com.ssa.entity.Note;

public interface INoteDAO {
	List<Note> getAllNotes();
	Note getNoteById(int noteId);
	boolean addNote(Note note);
	void updateNote(Note note);
	void deleteNote(Note note);
}
