package com.technoelevate.jesper_report.pojo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class EmployeePojo{
    private String id;
    private String name;
    private String password;
    private String designation;
    private double salary;
    private LocalDate doj;
}
