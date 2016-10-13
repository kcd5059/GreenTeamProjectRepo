package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ssa.entity.Member;

@Transactional
@Repository
public class MemberDAO implements IMemberDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    public MemberDAO(HibernateTemplate ht) {
    	this.hibernateTemplate = ht;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Member> getAllMembers() {
        String hql = "FROM Member as m ORDER BY m.id";
        return (List<Member>) hibernateTemplate.find(hql);
    }

	@Override
	public Member getMemberById(int memberId) {
		return (Member) hibernateTemplate.get(Member.class, memberId);
	}

	@Override
	public boolean addMember(Member member) {
		int result = (int) hibernateTemplate.save(member);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateMember(Member member) {
		Member record= getMemberById(member.getId());
		record.setFirst_name(member.getFirst_name());
		record.setLast_name(member.getLast_name());
		record.setId(member.getId());
		record.setGs_grade(member.getGs_grade());
		record.setRole(member.getRole());
		hibernateTemplate.update(record);
	}

	@Override
	public void deleteMember(Member member) {
		Member dbMember = getMemberById(member.getId());
		hibernateTemplate.delete(dbMember);
	}
}
