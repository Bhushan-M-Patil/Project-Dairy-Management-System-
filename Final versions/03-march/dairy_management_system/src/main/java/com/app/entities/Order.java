package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_date")
    @NotNull(message = "orderDate required")
    private LocalDate orderDate;
    
    @Column(name = "billAmount")
    @NotNull(message = "Bill required")
    private double billAmount;
    
  //--------------------------------------------------
    @ManyToMany(mappedBy = "orderList",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> productList;
    //--------------------------------------------------

    
 // -----------------------------------------------

 	@ManyToOne
 	@JoinColumn(name = "store_id")

 	private Store store;

 	// --------------------------------------

	public Long getId() {
		return id;
	}

	}
    
 
