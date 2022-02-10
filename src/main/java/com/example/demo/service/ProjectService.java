package com.example.demo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectrepository;
	
	public void save(@Valid Project project) {
		projectrepository.save(project);
	}
	
	public Iterable<Project> getProject() {
		return projectrepository.findAll();
	}

	public Optional<Project> getProject(Integer id) {
		return projectrepository.findById(id);
	}

}
