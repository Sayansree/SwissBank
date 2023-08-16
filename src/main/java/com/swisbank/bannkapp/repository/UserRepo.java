package com.swisbank.bannkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swisbank.bannkapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	public List<User> findByEmail(String num);
}
