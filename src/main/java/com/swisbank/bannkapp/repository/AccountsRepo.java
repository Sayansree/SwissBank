package com.swisbank.bannkapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swisbank.bannkapp.entity.Accounts;
public interface AccountsRepo extends JpaRepository<Accounts,Long> {

}
