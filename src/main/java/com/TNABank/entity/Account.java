package com.TNABank.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "accountNumber" }) })
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String accountNumber;
	private String libelle;
	private Double solde;
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	public Account(Long id, String accountNumber, String libelle, Double solde) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	

	

}
