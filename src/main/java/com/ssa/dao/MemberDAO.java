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
		hibernateTemplate.update(member);
	}

	@Override
	public void deleteMember(Member member) {
		Member dbMember = getMemberById(member.getId());
		hibernateTemplate.delete(dbMember);
	}
}
