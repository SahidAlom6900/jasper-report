package com.technoelevate.jesper_report.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.technoelevate.jesper_report.dto.Employee;
import com.technoelevate.jesper_report.pojo.EmployeePojo;

import net.sf.jasperreports.engine.JRException;

public interface EmployeeService {

	boolean exportReport(String format,HttpServletResponse response)throws JRException, IOException;

	Employee saveEmployee(EmployeePojo employeePojo);
}
