/**
 * 
 */
package com.am.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author sbiswas
 *
 */
@Entity(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "empcode")
	private String empCode;
	
	@Column(name = "emp_name")
	private String empName;

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empCode=");
		builder.append(empCode);
		builder.append(", empName=");
		builder.append(empName);
		builder.append("]");
		return builder.toString();
	}

}
