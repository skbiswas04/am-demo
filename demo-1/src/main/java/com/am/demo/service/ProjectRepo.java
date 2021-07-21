package com.am.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.am.demo.model.Project;

public interface ProjectRepo extends CrudRepository<Project, String> {

}
