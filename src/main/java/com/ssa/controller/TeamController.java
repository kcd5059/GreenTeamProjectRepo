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
import com.ssa.entity.Team;
import com.ssa.service.ITeamService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TeamController {

	@Autowired
	private ITeamService teamService;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public ResponseEntity<List<Team>> getAllTeams() {
		List<Team> teams = teamService.getAllTeams();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}

	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
	public ResponseEntity<Team> getTeamById(@PathVariable("id") Integer id) {
		Team team = teamService.getTeamById(id);
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/teamname/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getTeamNameById(@PathVariable("id") Integer id) {
		Team team = teamService.getTeamById(id);
		return new ResponseEntity<String>(team.getDescription(), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteteam/{id}", method = RequestMethod.DELETE)
	public void deleteTeam(@PathVariable("id") Integer id) {
		Team team = teamService.getTeamById(id);
		teamService.deleteTeam(team);
	}

	@RequestMapping(value="/updateteam", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTeam(@RequestBody Team team) {
		teamService.updateTeam(team);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value="/team", method = RequestMethod.POST)
	public ResponseEntity<Void> addTeam(@RequestBody Team team) {
		teamService.addTeam(team);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
