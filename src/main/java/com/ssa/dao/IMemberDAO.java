package com.ssa.dao;

import java.util.List;
import com.ssa.entity.Member;

public interface IMemberDAO {
	
	List<Member> getAllMembers();
	Member getMemberById(int memberId);
	boolean addMember(Member member);
	void updateMember(Member member);
	void deleteMember(Member member);

}
