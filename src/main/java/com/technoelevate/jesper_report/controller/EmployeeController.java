package com.technoelevate.jesper_report.controller;

import static com.technoelevate.jesper_report.common.EmployeeConstants.REPORT_GENERATE_FAIL_MESSAGE;
import static com.technoelevate.jesper_report.common.EmployeeConstants.REPORT_GENERATE_SUCCESS_MESSAGE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.jesper_report.dto.Employee;
import com.technoelevate.jesper_report.pojo.EmployeePojo;
import com.technoelevate.jesper_report.response.EmployeeResponseMessage;
import com.technoelevate.jesper_report.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/report/{format}")
	public ResponseEntity<EmployeeResponseMessage> generateReport(@PathVariable String format,
			HttpServletResponse response) throws JRException, IOException {
		if (service.exportReport(format, response)) {
			return new ResponseEntity<>(new EmployeeResponseMessage(false, REPORT_GENERATE_SUCCESS_MESSAGE,
					REPORT_GENERATE_SUCCESS_MESSAGE), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeResponseMessage(true, REPORT_GENERATE_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponseMessage> saveEmployee(@RequestBody EmployeePojo employeePojo) {
		Employee employee0 = service.saveEmployee(employeePojo);
		if (employee0 != null) {
			return new ResponseEntity<>(new EmployeeResponseMessage(false, REPORT_GENERATE_SUCCESS_MESSAGE, employee0),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeResponseMessage(true, REPORT_GENERATE_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}
}
