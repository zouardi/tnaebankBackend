package com.TNABank.model;

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
public class AccountModel {
	@NotNull
	private String accountNumber;
	@NotNull
	private String libelle;
	@NotNull
	private Long userId;
	private Double solde;

	public AccountModel(String accountNumber, String libelle, Double solde) {
		super();
		this.accountNumber = accountNumber;
		this.libelle = libelle;
		this.solde = solde;
	}

}
