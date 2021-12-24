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
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String reason;
	private Double amount;
	private Date valueDate;
	private String debitAccount;
	private String creditAccount;
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	public Transfer(Long id, String reason, Double amount, Date valueDate, String debitAccount, String creditAccount) {
		super();
		this.id = id;
		this.reason = reason;
		this.amount = amount;
		this.valueDate = valueDate;
		this.debitAccount = debitAccount;
		this.creditAccount = creditAccount;
	}
	
	
	
}
