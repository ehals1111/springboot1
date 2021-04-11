package com.example.demo.ex1;


import java.math.BigDecimal;
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
@Builder //생성자를 일일히 순서대로 넣기 불편하기때문에 @Builder라는 패턴을 이용해 값 순서 상관 없이 생성자에 값을 셋팅 할수 있음
@Accessors(chain= true) //. 연산자를 이용해 jquery처럼 .메소드().메소드() 이런식으로 값을 쉽게 이어서 넣을수 있음
public class Settlement { 
	
	@Id //primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql 사용하기에 identity를 사용
	private Long id;
	
	//@Column(name="account")칼럼과 비슷하면 안해줘도 됨
	private BigDecimal price;

	
	


}
