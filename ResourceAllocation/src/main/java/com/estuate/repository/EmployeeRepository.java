package com.estuate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estuate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByExperienceLessThanEqual(int experience);
}