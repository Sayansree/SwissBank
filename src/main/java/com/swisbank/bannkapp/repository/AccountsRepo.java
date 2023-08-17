package com.swisbank.bannkapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.User;
@Repository
public interface AccountsRepo extends JpaRepository<Accounts,Long> {
List<Accounts> findAllByOwner(User u);
}
