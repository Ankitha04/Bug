package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bug;
import com.example.demo.repository.BugRepository;

@Service
public class BugService {
@Autowired 
BugRepository bugRepository;

public Iterable<Bug> getbugs() {
	return bugRepository.findAll();
}

public Optional<Bug> getbugsbystatus(String status) {
	return bugRepository.findByStatus(status);
}

public Optional<Bug> getBugsByDescription(String description){
	return bugRepository.findByDescription(description);

}
@Transactional
public void addBugs(@Valid Bug bug) {
	// TODO Auto-generated method stub
	bugRepository.save(bug);
}
}
