package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//order_detail 테이블 자동연결
public class OrderDetail {

	private Long id;
	
	private LocalDateTime orderAt;
	
	private Long userId;
	
	private Long itemId;
	
}
