package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category {
	
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String type;
	
	private String title;
	
	private LocalDateTime createAt;
	
	private String createBy;
	
	private LocalDateTime updateAt;
	
	private String updatedBy;

}
