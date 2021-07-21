/**
 * 
 */
package com.am.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.am.demo.model.Employee;

/**
 * @author sbiswas
 *
 */
public interface EmployeeRepo extends CrudRepository<Employee, String>{

}
