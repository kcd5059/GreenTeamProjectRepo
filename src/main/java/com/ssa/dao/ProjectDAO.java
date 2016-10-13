package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.ssa.entity.Project;


public class ProjectDAO implements IProjectDAO {
	
	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    public ProjectDAO(HibernateTemplate ht) {
    	this.hibernateTemplate = ht;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> getAllProjects() {
        String hql = "FROM Project as p ORDER BY p.id";
        return (List<Project>) hibernateTemplate.find(hql);
    }

	@Override
	public Project getProjectById(int projectId) {
		return (Project) hibernateTemplate.get(Project.class, projectId);
	}

	@Override
	public boolean addProject(Project project) {
		int result = (int) hibernateTemplate.save(project);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateProject(Project project) {
		Project update = getProjectById(project.getId());
		update.setDescription(project.getDescription());
		update.setActive(project.getActive());
		hibernateTemplate.update(update);
	}

	@Override
	public void deleteProject(Project project) {
		Project delete = getProjectById(project.getId());
		hibernateTemplate.delete(delete);
	}
}
