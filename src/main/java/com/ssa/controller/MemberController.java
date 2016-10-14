package com.ssa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = memberService.getAllMembers();
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getMemberById(@PathVariable("id") Integer id) {
		Member member = memberService.getMemberById(id);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletemember/{id}", method = RequestMethod.DELETE)
	public void deleteMember(@PathVariable("id") Integer id) {
		Member member = memberService.getMemberById(id);
		memberService.deleteMember(member);
	}

	
	@RequestMapping(value="/updatemember", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMember(@RequestBody Member member) {
	//	System.err.println("POST: Member id is " + member.getId());
		memberService.updateMember(member);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(value="/member", method = RequestMethod.POST)
	public ResponseEntity<Void> addMember(@RequestBody Member member) {
		System.err.println("PUT: Member is " + member);
		memberService.addMember(member);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
