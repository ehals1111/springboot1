package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //lombok에서 자동으로 toString 을 해줌
@AllArgsConstructor
@NoArgsConstructor //기본생성자
@Entity // == table;
//@Table(name="user")
public class User { 
	
	@Id //primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql 사용하기에 identity를 사용
	private Long id;
	
	//@Column(name="account")칼럼과 비슷하면 안해줘도 됨
	private String account;
	
	private String email;
	
	private String phoneNumber;//jpa 에서 자동으로 매칭 해줌..
	
	/*
	 * camel case: 단어를 표기 할때 첫 문자는 소문자로 시작하며 띄어쓰기 대신 (대문자)로 단어를 구분 
	 * java의 변수를 선언할때 camelCase로 선언한다
	 * ex)phoneNumber, createAt,updatedAt
	 * 
	 * 
	 * Snake Case: 단어를 표기할때 모두 소문자로 표기하며, 띄어쓰기 대신 (_) 로 표기 db컬럼에 사용함
	 * ex)phone_number,created_at,updated_at
	 */
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
}
