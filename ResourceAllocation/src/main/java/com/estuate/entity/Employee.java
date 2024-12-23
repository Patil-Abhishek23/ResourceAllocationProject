package com.estuate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
   
    public Long ResourceId	;

    private String ResourceName;
    
    private int experience;

    @Column(length = 500)
    private String skills;

	public Long getResourceId() {
		return ResourceId;
	}

	public void setResourceId(Long resourceId) {
		ResourceId = resourceId;
	}

	public String getResourceName() {
		return ResourceName;
	}

	public void setResourceName(String resourceName) {
		ResourceName = resourceName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

  
}
