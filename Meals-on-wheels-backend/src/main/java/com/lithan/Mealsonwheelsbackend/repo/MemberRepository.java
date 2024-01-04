package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.Mealsonwheelsbackend.entity.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
	
	 //Check or Find existing mail - return true or false
    //For Register (duplicate mail)
    Member findByUsername(String username);
    
    
	List<Member> findByApprovedFalse();

	List<Member> findByApprovedTrue();

	List<Member> findByCaregiverId(Long caregiverId);
    
}
