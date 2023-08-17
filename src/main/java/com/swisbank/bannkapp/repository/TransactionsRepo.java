package com.swisbank.bannkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swisbank.bannkapp.entity.Transactions;

public interface TransactionsRepo extends JpaRepository<Transactions,Long> {

}
