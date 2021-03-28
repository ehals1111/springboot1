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

@Data
@AllArgsConstructor
@Entity // == table;
//@Table(name="user")
public class User {
	
	@Id //primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql ����ϱ⿡ identity�� ���
	private Long id;
	
	//@Column(name="account")Į���� ����ϸ� �����൵ ��
	private String account;
	
	private String email;
	
	private String phoneNumber;//jpa ���� �ڵ����� ��Ī ����..
	
	/*
	 * camel case: �ܾ ǥ�� �Ҷ� ù ���ڴ� �ҹ��ڷ� �����ϸ� ���� ��� (�빮��)�� �ܾ ���� 
	 * java�� ������ �����Ҷ� camelCase�� �����Ѵ�
	 * 
	 * 
	 */
	
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
}
