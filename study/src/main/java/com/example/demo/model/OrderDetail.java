package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//order_detail 테이블 자동연결
//lombok를 쓰게 되면 toString을 자동으로 만들어주는데 클래스끼리 상호참조하게 되면 toString을 계속 쓰게 되어 스택오버플로우 에러가 생김..
//@ToString(exclude = {"user","item"})
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	private LocalDateTime arrivalDate;
	
	private Integer quantity;
	
	private BigDecimal totalPrice;
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
	private Long itemId;//어떠한 상품
	
	private Long orderGroupId; //어떤한 장바구니에
	
	
	
	
	
	//private LocalDateTime orderAt;
	
	/*
	// 자신 N  :  1 유저
	//orderDetail 입장에선 자신은 n이고 유저는 1이기때문에 
	@ManyToOne
	//private Long userId; //user_id
	private User user; //하이버네이트 통한 연관관계 설정을 할때는 객체 이름을 적어야한다.
	//하이버네이트가 알아서 user_id를 찾아간다.
	
	//자신 N : 1 Item
	//private Long itemId;
	private Item item;
	*/
}
 