package com.am.demo.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.am.demo.model.ProjectEmployee;
import com.am.demo.model.ProjectEmployeeId;

public interface ProjectEmployeeRepo extends CrudRepository<ProjectEmployee, ProjectEmployeeId> {
	
	List<ProjectEmployee> findByDepartCodeAndProjCode(String departCode, String projCode);

}
