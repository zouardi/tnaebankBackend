package com.TNABank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TNABank.entity.Account;
import com.TNABank.model.AccountModel;
import com.TNABank.model.ApiCustomResponse;
import com.TNABank.model.ErrorData;
import com.TNABank.service.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/tna/ebankingService")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/addAccount")
	public ResponseEntity<?> addAccount(@RequestBody AccountModel accountModel) {

		return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(accountService.addAccount(accountModel)),
				HttpStatus.OK);
	}

	@GetMapping(value = "/users/{userId}/accounts")
	public ResponseEntity<?> getUserAcounts(@PathVariable Long userId) {
		List<Account> accounts = accountService.getUserAccounts(userId);
		if (accounts != null&& accounts.size()>0) {
			return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(accounts), HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiCustomResponse>(new ApiCustomResponse(new ErrorData("002", "Accounts not found")),
					HttpStatus.BAD_REQUEST);
		}
	}
}
