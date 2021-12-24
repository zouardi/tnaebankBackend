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
public class UserModel {
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	private String fullNuame;

}
