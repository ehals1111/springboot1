package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

@Data
@Entity 
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailsList","partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain= true)
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	private String name;
	
	private String title;
	
	private String content;
	 
	private Integer price;
	
	private String brandName;
	
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
	
	//Item N: 1 Partner
	@ManyToOne
	private Partner partner;
	
	
	//item 1 : N OrderDetail
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<OrderDetail> orderDetailsList;
	
	
	//자신 1 : N  OrderDetail
	
	//LAZY= 지연로딩 , EAGER = 즉시로딩
	
	//LAZY= SELECT * FROM ITEM WHERE ID =?
	
	//EAGER = 1:1 한건만 존재 할때 보통 사용함 모든 테이블의 조인을 쓰기때문에 문제가 생김..
	//보통 LAZY를 사용함..
	/*
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
	private List<OrderDetail> orderDetailList;*/

}
