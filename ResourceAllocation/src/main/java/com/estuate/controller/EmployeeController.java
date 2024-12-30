package com.estuate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
class EmployeeController {

	@Autowired
   	 public  EmployeeService service;

	
	//To Retrieve Employees who are having all the skills which are provided by user
    @GetMapping("/filter")  
    public List<String> filterEmployees(@RequestParam (required = false) List<String> skills,
                                         @RequestParam(required = false) Float maxExperience) {
	  
        return service.filterEmployees(skills, maxExperience);
    }
    
    
    
    //To Retrieve Employees who are having anyone of the skills which are provided by user  
    @GetMapping("/anyoneskill")
    public List<String> filterWithAltleastEmployees(@RequestParam (required = false) List<String> skills,
                                         @RequestParam(required = false) Float maxExperience) {
	   		
        return service.filterWithAltleastEmployees(skills, maxExperience);
    }

}

