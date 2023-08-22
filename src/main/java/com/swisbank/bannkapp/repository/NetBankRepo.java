package com.swisbank.bannkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swisbank.bannkapp.entity.NetBanking;

public interface NetBankRepo  extends JpaRepository<NetBanking,Long> {

}
