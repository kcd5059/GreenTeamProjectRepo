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
import com.ssa.entity.MemberTeamRel;
import com.ssa.service.IMemberTeamRelService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MemberTeamRelController {

	@Autowired
	private IMemberTeamRelService mtrService;

	@RequestMapping(value = "/memberteamrels", method = RequestMethod.GET)
	public ResponseEntity<List<MemberTeamRel>> getAllMTRs() {
		List<MemberTeamRel> mtrs = mtrService.getAllMTRs();
		return new ResponseEntity<List<MemberTeamRel>>(mtrs, HttpStatus.OK);
	}

	// Get list of teams given a projectId
	@RequestMapping(value = "/getmembers/{tid}", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> getAllMembersByTeamId(@PathVariable("tid") Integer tId) {
		List<Member> members = mtrService.getAllMembersByTeamId(tId);
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	@RequestMapping(value = "/memberteamrel/{id}", method = RequestMethod.GET)
	public ResponseEntity<MemberTeamRel> getMemberTeamRelById(@PathVariable("id") Integer id) {
		MemberTeamRel mtr = mtrService.getMemberTeamRelById(id);
		return new ResponseEntity<MemberTeamRel>(mtr, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletememberteamrel/{id}", method = RequestMethod.DELETE)
	public void deleteRel(@PathVariable("id") Integer id) {
		MemberTeamRel mtr = mtrService.getMemberTeamRelById(id);
		mtrService.deleteRel(mtr);
	}

	@RequestMapping(value = "/memberteamrel", method = RequestMethod.POST)
	public ResponseEntity<Void> addRel(@RequestBody MemberTeamRel mtr) {
		mtrService.addRel(mtr);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
