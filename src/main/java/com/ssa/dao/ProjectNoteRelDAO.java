package com.ssa.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Note;
import com.ssa.entity.ProjectNoteRel;

@Transactional
@Repository
public class ProjectNoteRelDAO implements IProjectNoteRelDAO {

	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    public ProjectNoteRelDAO(HibernateTemplate ht) {
    	this.hibernateTemplate = ht;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProjectNoteRel> getAllPNRs() {
        String hql = "FROM ProjectNoteRel as pnr ORDER BY pnr.id";
        return (List<ProjectNoteRel>) hibernateTemplate.find(hql);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Note> getAllNotesByProjectId(int pId) {
        String hql = "select n.id, n.message, n.time_stamp from Note as n JOIN ProjectNoteRel as "
        		+ "pnr on n.id = pnr.note_id where pnr.project_id = " + pId;
        return (List<Note>) hibernateTemplate.find(hql);
    }
    
    @Override
	public ProjectNoteRel getProjectNoteRelById(int pnrId) {
		return (ProjectNoteRel) hibernateTemplate.get(ProjectNoteRel.class, pnrId);
	}

	@Override
	public boolean addRel(ProjectNoteRel pnr) {
		int result = (int) hibernateTemplate.save(pnr);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteRel(ProjectNoteRel pnr) {
		ProjectNoteRel delete = getProjectNoteRelById(pnr.getId());
		hibernateTemplate.delete(delete);
	}
	
}
