package com.TNABank.repository;

import org.springframework.data.repository.CrudRepository;

import com.TNABank.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	

}