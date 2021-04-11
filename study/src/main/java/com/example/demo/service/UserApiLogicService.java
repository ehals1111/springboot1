package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

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
		
		//id -> repository getOne , getById
				
				Optional<User> optional = userRepository.findById(id);
		
				
		
		return optional.map(user -> response(user)).orElseGet(()->Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		// TODO Auto-generated method stub
		//1.data
		UserApiRequest userApiRequest = request.getData();
		
		//2.id -> user 데이터를 찾고
		Optional<User> optional = userRepository.findById(userApiRequest.getId());
		
		return optional.map(user -> {
			//3. update
			user.setAccount(userApiRequest.getAccount())
			.setPassword(userApiRequest.getPassword())
			.setStatus(userApiRequest.getStatus())
			.setPhoneNumber(userApiRequest.getPhoneNumber())
			.setEmail(userApiRequest.getEmail())
			.setRegisteredAt(userApiRequest.getRegisteredAt())
			.setUnregisteredAt(userApiRequest.getUnregisteredAt());
			return user;
		})
		.map(user -> userRepository.save(user))//update 가 되고
		.map(user -> response(user)) //4.userApiResponse
		
		.orElseGet(()->Header.ERROR("데이터 없음")); 
		
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		
		Optional<User> optional = userRepository.findById(id);
		
		return optional.map(user ->{
			
			userRepository.delete(user);
			
			return Header.OK();
			
		}).orElseGet(()->Header.ERROR("데이터 없음"));
		
		
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
