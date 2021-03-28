package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data //기본 생성자와 get set를 만들어줌..
@AllArgsConstructor // 모든 변수를 가진 생성자 추가
public class SearchParam {
	
	
	private String account;
	private String email;
	private int page;
	
	
}
