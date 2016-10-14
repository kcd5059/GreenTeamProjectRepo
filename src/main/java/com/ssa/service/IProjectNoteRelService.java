package com.ssa.service;

import java.util.List;

import com.ssa.entity.Note;
import com.ssa.entity.ProjectNoteRel;

public interface IProjectNoteRelService {

	List<ProjectNoteRel> getAllPNRs();
	ProjectNoteRel getProjectNoteRelById(int pnrId);
	List<Note> getAllNotesByProjectId(int pId);
	boolean addRel(ProjectNoteRel pnr);
	void deleteRel(ProjectNoteRel pnr);
}
