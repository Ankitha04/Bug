package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bug;
import com.example.demo.service.BugService;

@RestController
public class BugController {

	@Autowired
	BugService bugService;

	@GetMapping("/bugs")
	public Iterable<Bug> getBugs(){
	return bugService.getbugs();
	}

	@GetMapping("/bugs/{status}")
	public Optional<Bug> getBugsbyStatus(@PathVariable("status") String status){
		return bugService.getbugsbystatus(status);
	}
	@GetMapping("/bugs/{description}")
	public Optional<Bug> getBugsByDescription(@PathVariable("description") String description){
		return bugService.getBugsByDescription(description);
	}

	@PostMapping("/bugs")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addBugs(@RequestBody @Valid Bug bug) {
		bugService.addBugs(bug);
	}
}
