/**
 * 
 */
package com.am.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author sbiswas
 *
 */

@Entity(name = "project_employee")
@IdClass(ProjectEmployeeId.class)
public class ProjectEmployee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "projcode")
	@Id
	private String projCode;
	
	
	@Column(name = "departcode")
	@Id
	private String departCode;
	
	
	@Column(name = "empcode")
	@Id
	private String empCode;
	
	public String getProjCode() {
		return projCode;
	}
	public String getDepartCode() {
		return departCode;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}
	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectEmployee [projCode=");
		builder.append(projCode);
		builder.append(", departCode=");
		builder.append(departCode);
		builder.append(", empCode=");
		builder.append(empCode);
		builder.append("]");
		return builder.toString();
	}
	
	

}
