package com.ssa.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ssa.entity.ProjectTeamRel;

@Transactional
@Repository
public class ProjectTeamRelDAO implements IProjectTeamRelDAO {

	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    public ProjectTeamRelDAO(HibernateTemplate ht) {
    	this.hibernateTemplate = ht;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProjectTeamRel> getAllPTRs() {
        String hql = "FROM ProjectTeamRel as ptr ORDER BY ptr.id";
        return (List<ProjectTeamRel>) hibernateTemplate.find(hql);
    }
    
    @Override
	public ProjectTeamRel getProjectTeamRelById(int ptrId) {
		return (ProjectTeamRel) hibernateTemplate.get(ProjectTeamRel.class, ptrId);
	}

	@Override
	public boolean addRel(ProjectTeamRel ptr) {
		int result = (int) hibernateTemplate.save(ptr);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteRel(ProjectTeamRel ptr) {
		ProjectTeamRel delete = getProjectTeamRelById(ptr.getId());
		hibernateTemplate.delete(delete);
	}
}
