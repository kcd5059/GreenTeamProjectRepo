package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IProjectNoteRelDAO;
import com.ssa.entity.Note;
import com.ssa.entity.ProjectNoteRel;

@Service
public class ProjectNoteRelService implements IProjectNoteRelService {

	@Autowired
	private IProjectNoteRelDAO pnrDAO;
	
	@Override
	public List<ProjectNoteRel> getAllPNRs() {
		return pnrDAO.getAllPNRs();
	}
	
	@Override
	public List<Note> getAllNotesByProjectId(int pId) {
		return pnrDAO.getAllNotesByProjectId(pId);
	}

	@Override
	public ProjectNoteRel getProjectNoteRelById(int pnrId) {
		return pnrDAO.getProjectNoteRelById(pnrId);
	}

	@Override
	public boolean addRel(ProjectNoteRel pnr) {
		return pnrDAO.addRel(pnr);
	}

	@Override
	public void deleteRel(ProjectNoteRel pnr) {
		pnrDAO.deleteRel(pnr);
		
	}
}
