package com.am.demo.model;

import java.io.Serializable;

public class ProjectEmployeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private String projCode;
	private String departCode;
	private String empCode;
	
	public ProjectEmployeeId() {
		super();
	}
	
	public ProjectEmployeeId(String projCode, String departCode, String empCode) {
		super();
		this.projCode = projCode;
		this.departCode = departCode;
		this.empCode = empCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departCode == null) ? 0 : departCode.hashCode());
		result = prime * result + ((empCode == null) ? 0 : empCode.hashCode());
		result = prime * result + ((projCode == null) ? 0 : projCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectEmployeeId other = (ProjectEmployeeId) obj;
		if (departCode == null) {
			if (other.departCode != null)
				return false;
		} else if (!departCode.equals(other.departCode))
			return false;
		if (empCode == null) {
			if (other.empCode != null)
				return false;
		} else if (!empCode.equals(other.empCode))
			return false;
		if (projCode == null) {
			if (other.projCode != null)
				return false;
		} else if (!projCode.equals(other.projCode))
			return false;
		return true;
	}

	
}
