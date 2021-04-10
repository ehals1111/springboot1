package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SearchParam;
import com.example.demo.network.Header;

@RestController //이 클래스는 컨트롤러다
@RequestMapping("/api") // localhost:8080/api
public class getController {

	@RequestMapping(method= RequestMethod.GET , path ="/getMethod")
	public String getRequest() {
		
		return "Hi getMethod";
		
	}
	
	 
	@GetMapping("/getParameter")//http://localhost:8080/api/getParameter?id=wadasd&password=asdasdsa 
	//@RequestParam(name="password")  password라는 이름으로 값을 보내겠다고 설정하는. 
	public String getParameter(@RequestParam String id,@RequestParam(name="password") String pwd) {
		
		return id+pwd;
	} 
	
	@GetMapping("/getMultiParameter")
	public SearchParam getMultiParameter(SearchParam searchParam) {
		System.out.println(searchParam.getAccount());
		System.out.println(searchParam.getEmail());
		System.out.println(searchParam.getPage());
		//{"account" :"","email:"","page":0} json
		return searchParam;
	}
	
	@GetMapping("/header")
	public Header getHeader() {
		return Header.builder().resultCode("ok").description("ok").build();
	}
	
}
