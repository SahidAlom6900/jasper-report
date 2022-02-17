package com.technoelevate.jesper_report.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseMessage  {
	private boolean error;
	private String message;
	private Object data;
}
