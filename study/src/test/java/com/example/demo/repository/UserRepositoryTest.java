package com.example.demo.repository;


import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.User;



public class UserRepositoryTest extends StudyApplicationTests{
	
	@Autowired//DI ������ ����.. Dependency Injection
	private UserRepository userRepository ;
	
	
	//junit ����  �ذ��� ���� ���� �ּҷ� ã�� ������ Ŭ������ ����..
	//java.lang.NoClassDefFoundError: 
	//org/junit/platform/commons/util/ClassNamePatternFilterUtilsjava.lang.NoClassDefFoundError: org/junit/platform/commons/util/ClassNamePatternFilterUtils
	public void create() {
		
		User user = new User();
		//user.setId(); auto increment �� �ʿ����;
		user.setAccount("testuser01");
		user.setEmail("testuser01@gmail.com");
		user.setPhoneNumber("010-111-1111");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");
		
		User newUser = userRepository.save(user);
		System.out.println("newUser "+newUser);
	}
	
	@Test
	public void read() {
		Optional<User> user =userRepository.findById(2L);
		
		//ifPresent �������� ���� ..
		user.ifPresent(selectUser ->{
			System.out.println("user: "+selectUser);
			System.out.println("user: "+selectUser.getEmail());
			}
		);
	}
	
	public void update() {
		Optional<User> user =userRepository.findById(2L); //Ư�� ������ ����Ʈ ���ش� �׷��� Ư�������� �����Ҽ� �ֱ⶧����
		user.ifPresent(selectUser ->{
			selectUser.setAccount("pppp");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("updatge method()");
			
			userRepository.save(selectUser);
			}
		);
	}
	
	public void delete() {
		
	}
}
