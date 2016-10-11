package com.ssa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.entity.Member;
import com.ssa.service.IMemberService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	private IMemberService memberService;
	
	
	@RequestMapping(value= "/members", method = RequestMethod.GET)
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/member/{id}", method = RequestMethod.GET)
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Integer id) {
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/deletemember/{id}", method = RequestMethod.GET)
    public void deleteMember(@PathVariable("id") Integer id) {
        Member member = memberService.getMemberById(id);
        memberService.deleteMember(member);
    }
		@RequestMapping(value= "/updatemember/{id}/{fn}/{ln}/{gs}/{eod}/{role}", method = RequestMethod.GET)
	    public void updateMember(
	    		@PathVariable("id") Integer id, @PathVariable("fn") String fn, @PathVariable("ln") String ln,
	    		@PathVariable("gs") String gs, @PathVariable("eod") Date eod, @PathVariable("role") String role
	    		) {
	        Member member = memberService.getMemberById(id);
	        member.setFirst_name(fn);
	        member.setLast_name(ln);
	        member.setGs_grade(gs);
	        member.setE_o_d(eod);
	        member.setRole(role);
	        memberService.updateMember(member);
	    }
	
		@RequestMapping(value= "/addmember/{fn}/{ln}/{gs}/{eod}/{role}", method = RequestMethod.GET)
	    public boolean addMember(
	    		@PathVariable("fn") String fn, @PathVariable("ln") String ln,
	    		@PathVariable("gs") String gs, @PathVariable("eod") Date eod, @PathVariable("role") String role) {
			Member member = new Member();
			member.setFirst_name(fn);
	        member.setLast_name(ln);
	        member.setGs_grade(gs);
	        member.setE_o_d(eod);
	        member.setRole(role);
	        memberService.addMember(member);
	        return true; // wtf is this?
	    }

}
