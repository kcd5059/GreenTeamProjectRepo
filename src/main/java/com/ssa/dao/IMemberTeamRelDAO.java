package com.ssa.dao;

import java.util.List;
import com.ssa.entity.Member;
import com.ssa.entity.MemberTeamRel;

public interface IMemberTeamRelDAO {

	List<MemberTeamRel> getAllMTRs();
	MemberTeamRel getMemberTeamRelById(int mtrId);
	List<Member> getAllMembersByTeamId(int tId);
	boolean addRel(MemberTeamRel mtr);
	void deleteRel(MemberTeamRel mtr);
}
