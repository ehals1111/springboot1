package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.User;
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
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		// TODO Auto-generated method stub
		
		//1. request data
		UserApiRequest userApiRequest = request.getData();
		
		//2. user 생성
		User user = User.builder()
				.account(userApiRequest.getAccount())
				.password(userApiRequest.getPassword())
				.status("REGISTERED")
				.phoneNumber(userApiRequest.getPhoneNumber())
				.email(userApiRequest.getEmail())
				.registeredAt(LocalDateTime.now())
				.build();
				
		User newUser = userRepository.save(user);
		
		
		return response(newUser);
	}

	@Override
	public Header<UserApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Header<UserApiResponse> response(User user){
		
		UserApiResponse userApiResponse = UserApiResponse.builder()
				.id(user.getId())
				.account(user.getAccount())
				.password(user.getPassword())
				.email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.status(user.getStatus())
				.registeredAt(user.getRegisteredAt())
				.unregisteredAt(user.getUnregisteredAt())
				.build();
		// header data return
		return Header.OK(userApiResponse);
	}
}
