package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bug;

@Repository
public interface BugRepository extends CrudRepository<Bug,Integer> {

	Optional<Bug> findByStatus(String status);

	Optional<Bug> findByDescription(String description);

}
