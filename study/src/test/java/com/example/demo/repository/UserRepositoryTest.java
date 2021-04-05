package com.example.demo.repository;


import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.StudyApplicationTests;
import com.example.demo.model.User;


public class UserRepositoryTest extends StudyApplicationTests{
	
	@Autowired//DI 의존성 주입.. Dependency Injection
	private UserRepository userRepository ;
	
	
	//junit 에러  해결을 못함 밑의 주소로 찾아 들어가보니 클래스가 없음..
	//java.lang.NoClassDefFoundError: 
	//org/junit/platform/commons/util/ClassNamePatternFilterUtilsjava.lang.NoClassDefFoundError: org/junit/platform/commons/util/ClassNamePatternFilterUtils
	public void create() {
		
		User user = new User();
		//user.setId(); auto increment 라 필요없음;
		user.setAccount("testuser01");
		user.setEmail("testuser01@gmail.com");
		user.setPhoneNumber("010-111-1111");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");
		
		User newUser = userRepository.save(user);
		System.out.println("newUser "+newUser);
	}
	
	public void read() {
		
	}
	
	public void updaate() {
		
	}
}
