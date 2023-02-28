package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name")
	@Length(min=5, max=45, message = "Invalid")
	@NotBlank(message = "Name should not be null")
	private String productName;
	
	@Column
	@NotNull(message = "Price should not be null")
	private double price;
	
	@Column
	@NotNull(message = "Manufacture Date should not be null")
	private LocalDate manufactureDate;
	
	@Column
	@NotNull(message = "Expiry Date should not be null")
	@Future(message = "Expiry date must be in Future")
	private LocalDate expiryDate;
	
	@Column
	@NotNull(message = "Stock should not be null")
	private int stock;
	
}
