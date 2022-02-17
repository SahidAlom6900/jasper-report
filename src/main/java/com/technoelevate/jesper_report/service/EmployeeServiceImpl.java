package com.technoelevate.jesper_report.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.technoelevate.jesper_report.dto.Employee;
import com.technoelevate.jesper_report.pojo.EmployeePojo;
import com.technoelevate.jesper_report.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    public boolean exportReport(String reportFormat,HttpServletResponse response) throws JRException, IOException {
		List<Employee> employees = repository.findAll();
        File file = ResourceUtils.getFile("classpath:jasper-report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("datasource", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, dataSource);
        response.setHeader("Content-Disposition", "inline; filename=employees.pdf");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        return true;
    }


	public Employee saveEmployee(EmployeePojo employeePojo) {
		Employee employee=new Employee();
		if (employeePojo!=null) {
			BeanUtils.copyProperties(employeePojo, employee);
			return repository.save(employee);
		}
		return null;
	}
}
