package com.technoelevate.jesper_report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.jesper_report.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
