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
@Entity(name = "dept")
public class Department {

	@Id
	@Column(name = "departcode")
	private String projCode;
	
	@Column(name = "dept_name")
	private String deptName;

	public String getProjCode() {
		return projCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [projCode=");
		builder.append(projCode);
		builder.append(", deptName=");
		builder.append(deptName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
