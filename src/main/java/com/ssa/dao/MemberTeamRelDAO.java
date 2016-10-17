package com.ssa.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ssa.entity.Member;
import com.ssa.entity.MemberTeamRel;

@Transactional
@Repository
public class MemberTeamRelDAO implements IMemberTeamRelDAO {

	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    public MemberTeamRelDAO(HibernateTemplate ht) {
    	this.hibernateTemplate = ht;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MemberTeamRel> getAllMTRs() {
        String hql = "FROM MemberTeamRel as mtr ORDER BY mtr.id";
        return (List<MemberTeamRel>) hibernateTemplate.find(hql);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Member> getAllMembersByTeamId(int tId) {
        String hql = "select m.id, m.first_name, m.last_name, m.gs_grade, m.role from Member as m JOIN MemberTeamRel as "
        		+ "mtr on m.id = mtr.member_id where mtr.team_id = " + tId;
        return (List<Member>) hibernateTemplate.find(hql);
    }
    
    @Override
	public MemberTeamRel getMemberTeamRelById(int mtrId) {
		return (MemberTeamRel) hibernateTemplate.get(MemberTeamRel.class, mtrId);
	}

	@Override
	public boolean addRel(MemberTeamRel mtr) {
		int result = (int) hibernateTemplate.save(mtr);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteRel(MemberTeamRel mtr) {
		MemberTeamRel delete = getMemberTeamRelById(mtr.getId());
		hibernateTemplate.delete(delete);
	}

}
