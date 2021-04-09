package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity 
@AllArgsConstructor
@NoArgsConstructor
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
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
	private Long partnerId;
	
	//자신 1 : N  OrderDetail
	
	//LAZY= 지연로딩 , EAGER = 즉시로딩
	
	//LAZY= SELECT * FROM ITEM WHERE ID =?
	
	//EAGER = 1:1 한건만 존재 할때 보통 사용함 모든 테이블의 조인을 쓰기때문에 문제가 생김..
	//보통 LAZY를 사용함..
	/*
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
	private List<OrderDetail> orderDetailList;*/

}
