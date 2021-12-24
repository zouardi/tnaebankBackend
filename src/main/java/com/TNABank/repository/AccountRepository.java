package com.TNABank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.TNABank.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	@Query("select new Account(  id,  accountNumber,  libelle,  solde) from Account a where a.user.id =?1")
	List<Account> findAccountsByUser(Long userId);

//	
//	@Transactional
//	@Modifying
//	@Query("update Account a set a.solde = a.solde + ?1 where a.id = ?2")
//	void updateAccountSold(float amount, int id);

	Optional<Account> findByAccountNumber(String debitAccount);
}