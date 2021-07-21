/**
 * 
 */
package com.am.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.am.demo.exception.DepartmentNotFoundException;
import com.am.demo.exception.EmployeetNotFoundException;
import com.am.demo.exception.ProjectNotFoundException;
import com.am.demo.model.Department;
import com.am.demo.model.Employee;
import com.am.demo.model.Project;
import com.am.demo.model.ProjectEmployee;
import com.am.demo.model.ProjectEmployeeId;
import com.am.demo.service.DepartmentRepo;
import com.am.demo.service.EmployeeRepo;
import com.am.demo.service.ProjectEmployeeRepo;
import com.am.demo.service.ProjectRepo;

/**
 * @author sbiswas
 *
 * 	Resources:
 * 		Department: /dept
 * 		Project:	/project
 * 		Employee:	/emp
 */

@RestController
public class AppController {
	
	private static final Log _log = LogFactory.getLog(AppController.class);
	
	@Autowired
	DepartmentRepo deptRepo;
	
	@Autowired
	ProjectRepo projRepo;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	ProjectEmployeeRepo projEmployeeRepo;
	
	/**
	 * Fetches all employees of a given project.
	 * Since a project can be associated with multiple departments, department code must be specified.
	 * 
	 * @param departCode
	 * @param projCode
	 * @return
	 */
	@GetMapping("/dept/{departCode}/project/{projCode}/emp")
	public List<Employee> getProjectEmployees(@PathVariable("departCode") String departCode,
				@PathVariable("projCode") String projCode){
		
		_log.info("Get employees of departCode: "+departCode+" and projCode: "+projCode);
		
		Optional<Department> department = deptRepo.findById(departCode);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department: "+departCode +" not found");
		}
		
		Optional<Project> project = projRepo.findById(projCode);
		if(!project.isPresent()) {
			throw new ProjectNotFoundException("Project: "+projCode+ " not found");
		}
		
		List<Employee> employeeList = new ArrayList<>();
		
		List<ProjectEmployee> projEmployeeList = projEmployeeRepo.findByDepartCodeAndProjCode(departCode, projCode);
		
		_log.info(" projEmployeeList: "+projEmployeeList);
		for (ProjectEmployee projectEmployee : projEmployeeList) {
			Optional<Employee> optionalEmp = empRepo.findById(projectEmployee.getEmpCode());
			optionalEmp.ifPresent(employee -> {
					_log.info("Employee fetched: "+employee.getEmpName());
					employeeList.add(employee);
				}
			);
		}
		
		return employeeList;
		 
	}
	
	/**
	 * Releases an employee from a given project.
	 * Since a project code can be associated with multiple departments, department code must be specified.
	 * 
	 * @param departCode
	 * @param projCode
	 * @param empCode
	 * @return
	 */
	@DeleteMapping("/dept/{departCode}/project/{projCode}/emp/{empCode}")
	public String releaseProjectEmployee(@PathVariable("departCode") String departCode,
			@PathVariable("projCode") String projCode, @PathVariable("empCode") String empCode) {
		
		_log.info("Releasing employee: "+empCode+" from project: "+projCode+" of department: "+departCode);
		
		Optional<Department> department = deptRepo.findById(departCode);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department: "+departCode +" not found");
		}
		
		Optional<Project> project = projRepo.findById(projCode);
		if(!project.isPresent()) {
			throw new ProjectNotFoundException("Project: "+projCode+ " not found");
		}
		
		Optional<Employee> employee = empRepo.findById(empCode);
		if(!employee.isPresent()) {
			throw new EmployeetNotFoundException("Employee: "+empCode+ " not found");
		}
		
		ProjectEmployeeId projEmpId = new ProjectEmployeeId(projCode, departCode, empCode);
		
		projEmployeeRepo.deleteById(projEmpId);
		
		return "Deletion success";
	}

}
