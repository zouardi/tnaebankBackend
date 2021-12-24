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
public class TransferModel {

	@NotNull
	private Long userId;
	@NotNull
	private String debitAccount;
	@NotNull
	private String creditAccount;
	@NotNull
	private Double amount;
	@NotNull
	private String reason;

}
