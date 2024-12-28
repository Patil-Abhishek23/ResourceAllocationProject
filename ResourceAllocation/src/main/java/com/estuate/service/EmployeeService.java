package com.estuate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estuate.entity.Employee;
import com.estuate.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	  @Autowired
	  public  EmployeeRepository repository;
	    
	  public List<String> filterEmployees(List<String> skills, Integer maxExperience) {
		    // Retrieve employees based on experience or all employees
		    List<Employee> employees = (maxExperience != null)
		            ? repository.findByExperienceLessThanEqual(maxExperience)
		            : repository.findAll();

		    
		    List<String> result = new ArrayList<>();

		    // Checking through the employees by skills
		    for (Employee employee : employees) {
		        
		        String[] employeeSkillsArray = employee.getSkills().split(",");
		        List<String> employeeSkills = new ArrayList<>();
		        for (String skill : employeeSkillsArray) {
		            employeeSkills.add(skill.trim().toLowerCase());
		        }

		      
		        boolean allSkillsMatch = true;
		        for (String skill : skills) {
		            if (!employeeSkills.contains(skill.toLowerCase())) {
		                allSkillsMatch = false;
		                break;
		            }
		        }

		        // add name of the employee who are having all of the skills
		        if (allSkillsMatch) {
		            result.add(employee.getResourceName());
		        }
			    if(result.isEmpty()){
					result.add("No Employee Found");
				}
		    }

		    // Return the names of employees that have matched the skills
		    return result;
		}

	    	
	  
	  public List<String> filterWithAltleastEmployees(List<String> skills, Integer maxExperience) {
		  // Retrieve employees based on experience or all employees
		    List<Employee> employees = (maxExperience != null)
		            ? repository.findByExperienceLessThanEqual(maxExperience)
		            : repository.findAll();

		    
		    List<String> result = new ArrayList<>();

		    // Checking through the employees by skills
		    for (Employee employee : employees) {
		        
		        String[] employeeSkillsArray = employee.getSkills().split(",");
		        List<String> employeeSkills = new ArrayList<>();
		        for (String skill : employeeSkillsArray) {
		            employeeSkills.add(skill.trim().toLowerCase());
		        }

		        // Check if the employee has at least one of the required skills
		        boolean hasAnySkill = false;
		        for (String skill : skills) {
		            if (employeeSkills.contains(skill.toLowerCase())) {
		                hasAnySkill = true;
		                break;
		            }
		        }

		     // add name of the employee who are having any one of the skill
		        if (hasAnySkill) {
		            result.add(employee.getResourceName());
		        }
		    }

		    /// Return the names of employees that have matched any one the skills
		    return result;
		}

}
