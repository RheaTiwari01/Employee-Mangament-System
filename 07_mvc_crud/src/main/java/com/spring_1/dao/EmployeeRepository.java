package com.spring_1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
// add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
