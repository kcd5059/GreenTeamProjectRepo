package com.ssa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssa.dao.IMemberTeamRelDAO;
import com.ssa.entity.Member;
import com.ssa.entity.MemberTeamRel;

@Service
public class MemberTeamRelService implements IMemberTeamRelService {

	@Autowired
	private IMemberTeamRelDAO mtrDAO;
	
	@Override
	public List<MemberTeamRel> getAllMTRs() {
		return mtrDAO.getAllMTRs();
	}

	@Override
	public MemberTeamRel getMemberTeamRelById(int mtrId) {
		return mtrDAO.getMemberTeamRelById(mtrId);
	}

	@Override
	public boolean addRel(MemberTeamRel mtr) {
		return mtrDAO.addRel(mtr);
	}

	@Override
	public void deleteRel(MemberTeamRel mtr) {
		mtrDAO.deleteRel(mtr);
		
	}

	@Override
	public List<Member> getAllMembersByTeamId(int tId) {
		return mtrDAO.getAllMembersByTeamId(tId);
	}
}
