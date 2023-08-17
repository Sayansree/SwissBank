package com.swisbank.bannkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.Transactions;
@Repository
public interface TransactionsRepo extends JpaRepository<Transactions,Long> {
	public List<Transactions> findAllBySenderInOrReceiverIn(List<Accounts> l1,List <Accounts> l2);
}
