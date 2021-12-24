package com.TNABank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TNABank.entity.Account;
import com.TNABank.entity.Transaction;
import com.TNABank.entity.Transfer;
import com.TNABank.model.TransferModel;
import com.TNABank.entity.User;
import com.TNABank.repository.AccountRepository;
import com.TNABank.repository.TransactionRepository;
import com.TNABank.repository.TransferRepository;
import com.TNABank.repository.UserRepository;

@Service

public class TransferService {

	@Autowired
	TransferRepository transferRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionRepository transactionRepository;

	public Transfer makeTransfer(TransferModel transferModel) {

		Optional<User> userData = userRepository.findById(transferModel.getUserId());

		Transfer transfer = new Transfer();

		transfer.setUser(userData.get());
		transfer.setAmount(transferModel.getAmount());
		transfer.setCreditAccount(transferModel.getCreditAccount());
		transfer.setDebitAccount(transferModel.getDebitAccount());
		transfer.setReason(transferModel.getReason());
		transfer.setValueDate(new Date());

		Transfer transferData = transferRepository.save(transfer);

		Optional<Account> debitAccountOptional = accountRepository.findByAccountNumber(transferModel.getDebitAccount());
		if (debitAccountOptional.isPresent()) {
			Account debitAccount = debitAccountOptional.get();
			debitAccount.setSolde(debitAccount.getSolde() - transferModel.getAmount());
			accountRepository.save(debitAccount);

			Transaction transaction = new Transaction();

			transaction.setLibelle("virement emis " + transferModel.getReason());
			transaction.setMovementAmount(-transferModel.getAmount());
			transaction.setMovementDate(new Date());
			transaction.setAccount(debitAccount);

			transactionRepository.save(transaction);
		}

		Optional<Account> creditAccountOptional = accountRepository
				.findByAccountNumber(transferModel.getCreditAccount());
		if (creditAccountOptional.isPresent()) {
			Account creditAccount = creditAccountOptional.get();
			creditAccount.setSolde(creditAccount.getSolde() + transferModel.getAmount());
			accountRepository.save(creditAccount);

			Transaction transaction = new Transaction();

			transaction.setLibelle("virement recu " + transferModel.getReason());
			transaction.setMovementAmount(transferModel.getAmount());
			transaction.setMovementDate(new Date());
			transaction.setAccount(creditAccount);

			transactionRepository.save(transaction);
		}

		return transferData;

	}

	public List<Transfer> getUserTransfers(Long userId) {
		
		
		List<Transfer> transfers = transferRepository.findTransfersByUserId(userId);
		return transfers;
	}
}
