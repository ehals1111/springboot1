package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data //�⺻ �����ڿ� get set�� �������..
@AllArgsConstructor // ��� ������ ���� ������ �߰�
public class SearchParam {
	
	
	private String account;
	private String email;
	private int page;
	
	
}
