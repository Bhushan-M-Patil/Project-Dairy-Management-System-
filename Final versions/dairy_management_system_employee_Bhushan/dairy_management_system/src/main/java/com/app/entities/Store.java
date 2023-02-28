package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
@Entity
@Table(name = "store")

public class Store {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "store_name",length = 20)
	@NotBlank(message = "Name must be required")
	private  String storeName;
	
	@Column(name = "address",length = 30)
	@NotBlank(message = "Address required")
	private  String address;
	
	@NotBlank(message = "Email Should not be blank")
	@Column(name = "email",length = 30)
	private String email;
	
	@NotBlank
//	@JsonProperty(access = Access.WRITE_ONLY)//will be used during deserilization
	private String password;
	
	@NotNull
	@Column(name = "phone_no",length = 20)
	private Long phoneNumber;
}

