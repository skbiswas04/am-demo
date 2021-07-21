package com.am.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.am.demo.model.Department;

public interface DepartmentRepo extends CrudRepository<Department, String> {

}
