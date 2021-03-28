package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SearchParam;

@RestController
@RequestMapping("/api")
public class postController {

	// Html<form>
	//ajax 검색
	// http post body -> data
	// json, xml , multipart -form / text-plain
	
	@PostMapping(value="/postMethod")//, produces= {"application-json"})
	public SearchParam postMethod(@RequestBody SearchParam searchParam) {
		
		return searchParam;
	}
	//구글 확장프로그램  rest client
	
	/*{ "account" : "aaaa",
		"email" : "pppaa@naver.com",
		"page": 50
		}*/
	
	 
}
