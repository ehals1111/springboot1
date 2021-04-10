package com.example.demo.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data  //lombok에서 자동으로 toString 을 해줌
@AllArgsConstructor
@NoArgsConstructor //기본생성자
@Entity // == table;
//@Table(name="user")
@ToString(exclude = {"orderGroup"})
@Builder //생성자를 일일히 순서대로 넣기 불편하기때문에 @Builder라는 패턴을 이용해 값 순서 상관 없이 생성자에 값을 셋팅 할수 있음
@Accessors(chain= true) //. 연산자를 이용해 jquery처럼 .메소드().메소드() 이런식으로 값을 쉽게 이어서 넣을수 있음
@EntityListeners(AuditingEntityListener.class)
public class User { 
	
	@Id //primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql 사용하기에 identity를 사용
	private Long id;
	
	//@Column(name="account")칼럼과 비슷하면 안해줘도 됨
	private String account;
	
	private String password;
	
	private String status;
	
	private String email;
	
	private String phoneNumber;//jpa 에서 자동으로 매칭 해줌..
	
	private LocalDateTime registeredAt;
	
	private LocalDateTime unregisteredAt;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;
	
	
	//User 1 : N OrderGrop
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<OrderGroup> orderGroup;
	
	 
	//user 입장에선 자신이 1이고 orderDetail은 n이다.
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//mappedBy = "user" OrderDetail클래스 안에 user변수를 매칭 시키겠다
	//private List<OrderDetail> orderDetailList;
	
	
	/*
	 * camel case: 단어를 표기 할때 첫 문자는 소문자로 시작하며 띄어쓰기 대신 (대문자)로 단어를 구분 
	 * java의 변수를 선언할때 camelCase로 선언한다
	 * ex)phoneNumber, createAt,updatedAt
	 * 
	 * 
	 * Snake Case: 단어를 표기할때 모두 소문자로 표기하며, 띄어쓰기 대신 (_) 로 표기 db컬럼에 사용함
	 * ex)phone_number,created_at,updated_at
	 */
}
