package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JPA annotations
@Entity
@Table(name="Employee")

//Lombok annotations
@NoArgsConstructor //=def arg less ctor
@Getter //all getters
@Setter //all setters
@ToString(exclude = "password")//toString excluding password

//how to exclude null or blank(default) values during ser ?
//@JsonInclude(Include.NON_DEFAULT)

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCEGENERATOR")
	@SequenceGenerator(name = "SEQUENCEGENERATOR", allocationSize = 1, initialValue = 1000, sequenceName = "SEQUENCE_GENERATOR")
	@Column(name = "employee_id")
	private Long id;
	
	@Column(length = 25,unique = true)
	private String email;
	
	@Column(length = 25)
	//How to tell Jackson (i.e a vendor for ser n deserial) to skip the property
	//from ser yet retain during de-ser ? 
	@JsonProperty(access = Access.WRITE_ONLY) // only setter will be accessible during conversion
	//Jackson uses : getters : during ser. n setters during de-ser.
	@NotBlank
	private String password;
	
	@Column(length = 45)
	@NotBlank(message = "Employee Name is required!!!!")
	private String name;
	
	@Column(nullable = false)
	@NotNull
	private double salary;
	
	
	@Column(length = 15)
	@NotBlank
	private String gender;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable = false, length = 45)
//	@NotBlank  do not use for Enum
	private Role employeeRole ;
	
	@Future(message = "join  date must be in future")
	@NotNull
	private LocalDate joiningDate;
	
	@Column( length = 15, nullable = false)
	@NotBlank
	private String phoneNo;

	public Employee(String email, @NotBlank(message = "Employee Name is required!!!!") String name, double salary,
			String gender, Role employeeRole, @Future(message = "join  date must be in future") LocalDate joiningDate,
			String phoneNo) {
		super();
		this.email = email;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.employeeRole = employeeRole;
		this.joiningDate = joiningDate;
		this.phoneNo = phoneNo;
	}
	
}
