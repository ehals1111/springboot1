package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.network.Header;
import com.example.demo.network.request.UserApiRequest;
import com.example.demo.network.response.UserApiResponse;
import com.example.demo.repository.UserRepository;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse>{
	
	@Autowired
	private UserRepository userRepository;
	
	//1. request data
	//2. user 생성
	//3. 생성된 데이터 -> userApiResponse return
	@Override
	public Header<UserApiResponse> create(UserApiRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<UserApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<UserApiResponse> update(UserApiRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
