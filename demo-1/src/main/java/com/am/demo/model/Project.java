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
@Entity(name = "project")
public class Project {
	@Id
	@Column(name = "projcode")
	private String projCode;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "departcode")
	private String departCode;

	public String getProjCode() {
		return projCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getDepartCode() {
		return departCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [projCode=");
		builder.append(projCode);
		builder.append(", projectName=");
		builder.append(projectName);
		builder.append(", departCode=");
		builder.append(departCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
