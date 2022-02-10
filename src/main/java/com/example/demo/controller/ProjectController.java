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

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectservice;
	
	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveProject(@RequestBody @Valid Project project) {
		projectservice.save(project);
	}
	
	@GetMapping("/project")
	Iterable<Project> getProject() {
		return projectservice.getProject();
	}
	
	@GetMapping("/project/{id}")
	Optional<Project> getProject(@PathVariable Integer id) {
		return projectservice.getProject(id);
	}
	

}
