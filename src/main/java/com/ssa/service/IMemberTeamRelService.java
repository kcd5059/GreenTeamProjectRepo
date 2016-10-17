package com.ssa.service;

import java.util.List;

import com.ssa.entity.Member;
import com.ssa.entity.MemberTeamRel;

public interface IMemberTeamRelService {

	List<MemberTeamRel> getAllMTRs();
	MemberTeamRel getMemberTeamRelById(int mtrId);
	List<Member> getAllMembersByTeamId(int tId);
	boolean addRel(MemberTeamRel mtr);
	void deleteRel(MemberTeamRel mtr);
}
