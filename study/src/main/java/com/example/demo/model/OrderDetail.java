package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity//order_detail 자동으로 바뀜
public class OrderDetail {

	private Long id;
	
	private LocalDateTime orderAt;
	
	private Long userId;
	
	private Long itemId;
	
}
