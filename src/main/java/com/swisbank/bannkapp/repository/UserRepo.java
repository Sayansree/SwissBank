package com.swisbank.bannkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swisbank.bannkapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	public List<User> findByEmail(String num);
	public List<User> findByNameContainingIgnoreCase(String name);
	public List<User> findByEmailContainingIgnoreCase(String email);
	public List<User> findByPhone(long phone);
}
