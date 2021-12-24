package com.TNABank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date movementDate;
	private Double movementAmount;
	private String libelle;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Account Account;

	public Transaction(Long id, Date movementDate, Double movementAmount, String libelle) {
		super();
		this.id = id;
		this.movementDate = movementDate;
		this.movementAmount = movementAmount;
		this.libelle = libelle;
	}
	
	

	

}
