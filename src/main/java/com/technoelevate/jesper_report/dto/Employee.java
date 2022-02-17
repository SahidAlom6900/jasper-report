package com.technoelevate.jesper_report.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "EMPLOYEE_DETAILS")
@JsonIgnoreProperties({"password"})
public class Employee implements Serializable{
    @Id
    private String id;
    private String name;
    private String password;
    private String designation;
    private double salary;
    private LocalDate doj;
}
