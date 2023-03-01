package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//exclude null or blank(default)
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "billIdSequence")
	@SequenceGenerator(allocationSize = 1, initialValue = 9000, name = "billIdSequence")
	private Long billId;
	
	@Column(length = 20)
	@NotNull
	private LocalDate billDate;
	
	@Column(length = 5)
	private Double buffaloMilkQuantity;
	
	@Column(length = 5, precision = 2)
	private Double buffaloMilkFat;
	
	@Column(length = 4)
	private Double cowMilkQuantity;
	
	@Column(precision = 2)
	private Integer cowMilkFat;
	
	@Column(precision = 2)
	private Double totalAmount;
	
	@Column(length = 25)
	@NotNull
	private Integer supplierId;
}
