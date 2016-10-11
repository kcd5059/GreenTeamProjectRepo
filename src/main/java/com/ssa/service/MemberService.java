package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IMemberDAO;
import com.ssa.entity.Member;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDAO memberDAO;

	@Override
	public List<Member> getAllMembers() {
		return memberDAO.getAllMembers();
	}

	@Override
	public Member getMemberById(int memberId) {
		return memberDAO.getMemberById(memberId);
	}

	@Override
	public boolean addMember(Member member) {
		return memberDAO.addMember(member);
	}

	@Override
	public void updateMember(Member member) {
		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(Member member) {
		memberDAO.deleteMember(member);
		
	}

}
