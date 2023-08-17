package com.swisbank.bannkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.Transactions;

public interface TransactionsRepo extends JpaRepository<Transactions,Long> {
//	@Query("")
	public List<Transactions> findBySenderInOrReceiverIn(List<Accounts> l1,List <Accounts> l2);
}
