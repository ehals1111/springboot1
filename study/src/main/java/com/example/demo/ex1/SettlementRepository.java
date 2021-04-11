package com.example.demo.ex1;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement,Long> {
	
	
	
	
	/*
	// JpaRepository<User << 테이블에 관련된 model명 ,Long   << 테이블의 primarykey의 데이터 타입>
	
	//select * from user where account = ?
	Optional<User> findByAccount(String accont);
	
	Optional<User> findByEmail(String email);
	
	
	//여러가지 검색
	//select * from user where account = ? and email=?
	Optional<User> findByAccountAndEmail(String account, String email);
	*/
}	
