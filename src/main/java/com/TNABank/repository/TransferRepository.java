package com.TNABank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.TNABank.entity.Transfer;

public interface TransferRepository extends CrudRepository<Transfer, Long> {

	@Query("select new Transfer(  id,  reason,  amount,  valueDate,  debitAccount,  creditAccount) from Transfer t where t.user.id =?1 order by t.valueDate desc")
	List<Transfer> findTransfersByUserId(Long userId);

//	@Query("select t from Transfer t where t.user.id =?1 order by t.valueDate desc")
//	List<Transfer> findTransfersByUserId(Long userId);
}
