package com.TNABank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TNABank.entity.Account;
import com.TNABank.entity.User;
import com.TNABank.model.AccountModel;
import com.TNABank.repository.AccountRepository;
import com.TNABank.repository.UserRepository;

@Service

public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	UserRepository userRepository;

	public List<Account> getUserAccounts(Long id) {

		List<Account> userAccounts = accountRepository.findAccountsByUser(id);
		return userAccounts;
	}

	public Object addAccount(AccountModel accountModel) {

		Optional<User> userData = userRepository.findById(accountModel.getUserId());

		Account account = new Account();

		account.setAccountNumber(accountModel.getAccountNumber());
		account.setLibelle(accountModel.getLibelle());
		account.setSolde(0D);
		account.setUser(userData.get());

		account = accountRepository.save(account);

		return account;
	}

}
