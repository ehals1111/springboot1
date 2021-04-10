package com.example.demo.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
	//api 통신시간
	//@JsonProperty(transaction_Time) 카멜케이스를 스네이크케이스로 바꿔줌
	private LocalDateTime transactionTime;
	
	//api 응답코드
	private String resultCode;
	
	//api 부가설명
	private String description;
	
	private T data;//header<T> 제네릭을 붙혀주고 데이터를 넣어줌..
	
	//OK
	public static <T> Header<T> OK(){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	
	//DATA OK
	public static <T> Header<T> OK(T data){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.data(data)
				.build();
	}
	
	// ERROR
	public static <T> Header<T> ERROR(String description){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("ERROR")
				.description(description)
				.build();
	}
}
