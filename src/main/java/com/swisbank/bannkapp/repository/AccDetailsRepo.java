package com.swisbank.bannkapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swisbank.bannkapp.entity.AccountDetails;
@Repository
public interface AccDetailsRepo extends JpaRepository<AccountDetails,Long> {
//List<Accounts> findAllByOwner(User u);
	List<AccountDetails> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String s1,String s2);
	List<AccountDetails> findByFirstNameContainingIgnoreCaseOrMiddleNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String s1,String s2,String s3);
	List<AccountDetails> findByMobile(long num);
	List<AccountDetails> findByAdharCard(long num);
	List<AccountDetails> findByAddrResContainingIgnoreCaseOrAddrPerContainingIgnoreCase(String c1,String c2);
}
