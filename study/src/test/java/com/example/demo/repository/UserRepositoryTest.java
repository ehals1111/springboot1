package com.example.demo.repository;


import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.StudyApplicationTests;

import com.example.demo.model.User;

import lombok.experimental.Accessors;





public class UserRepositoryTest extends StudyApplicationTests{
	
	@Autowired//DI 의존성 주입.. Dependency Injection
	private UserRepository userRepository ;
	
	
	//junit 에러  해결을 못함 밑의 주소로 찾아 들어가보니 클래스가 없음..
		//java.lang.NoClassDefFoundError: 
		//org/junit/platform/commons/util/ClassNamePatternFilterUtilsjava.lang.NoClassDefFoundError: org/junit/platform/commons/util/ClassNamePatternFilterUtils
	@Test
	public void create() {
		String account = "Test03";
		String password= "Test03";
		String status ="REGISTERED";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-3333";
		LocalDateTime registeredAt=LocalDateTime.now();
		LocalDateTime createAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setStatus(status);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRegisteredAt(registeredAt);
		//user.setCreatedAt(createAt);
		//user.setCreatedBy(createdBy);
		
		
		//생성자를 일일히 순서대로 넣기 불편하기때문에 @Builder라는 패턴을 이용해 값 순서 상관 없이 생성자에 값을 셋팅 할수 있음
		User u = User.builder()
				.account(account)
				.password(password)
				.status(status)
				.email(email)
				.build();
		
		//@Accessors(chain= true)
		user.setEmail(email).setPhoneNumber(phoneNumber).setStatus(status);
		
		User newUser = userRepository.save(user);
		
		Assert.assertNotNull(newUser);
		
		
		
		/*
		User user = new User();
		//user.setId(); auto increment 라 필요없음;
		user.setAccount("testuser01");
		user.setEmail("testuser01@gmail.com");
		user.setStatus("aaa");
		user.setPassword("123123123");
		user.setPhoneNumber("010-111-1111");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");

		User newUser = userRepository.save(user);
		System.out.println("newUser=  "+newUser);
		*/
	}
	
	//@Test
	//@Transactional
	public void read() {
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		System.out.println(user);
		if(user != null) { 
			user.getOrderGroup().stream().forEach(orderGroup->{
				System.out.println("------주문 묶음 -----------");
				System.out.println("수령인 :"+orderGroup.getRevName());
				System.out.println("수령지 :"+orderGroup.getRevAddress());
				System.out.println("총금액 :"+orderGroup.getTotalPrice());
				System.out.println("총수량 :"+orderGroup.getTotalQuantity());
				
				
				System.out.println("-----------주문상세--------------");
				orderGroup.getOrderDetailList().forEach(orderDetail ->{
					System.out.println("파트너사 이름 :"+orderDetail.getItem().getPartner().getName());
					System.out.println("파트너사 카테고리 :"+orderDetail.getItem().getPartner().getCategory().getTitle());
					System.out.println("주문상품 : "+orderDetail.getItem().getName());
					System.out.println("고객센터 번호 :"+orderDetail.getItem().getPartner().getCallCenter());
					System.out.println("주문의 상태 :" +orderDetail.getStatus());
					System.out.println("도척예정일자 :" +orderDetail.getArrivalDate());
					
				});
			
			});
		}
		Assert.assertNotNull(user);
		
		//findById  = select * from user where id=?
		//Optional<User> user =userRepository.findById(2L);
		//Optional<User> user =userRepository.findByAccount("Test07");
		 
		//ifPresent 있을때만 값을..
		//user.ifPresent(selectUser ->{
			//System.out.println("user: "+selectUser);
			//System.out.println("user: "+selectUser.getEmail());
			//selectUser.getOrderDetailList().stream().forEach(detail ->{
				//Item item = detail.getItem();
				//System.out.println(detail.getItem());
				
			//});
			//}
		//); 
	}
	
	//@Test
	//@Transactional
	public void update() {
		Optional<User> user =userRepository.findById(2L); //특정 유저를 셀렉트 해준다 그래야 특정유저를 수정할수 있기때문에
		user.ifPresent(selectUser ->{
			selectUser.setAccount("pppp");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("updatge method()");
			
			userRepository.save(selectUser);
			}
		);
	}
	
	//@Test
	//@Transactional //실행을 하더라도 마지막에 롤백 해줌..
	public void delete() {
		Optional<User> user =userRepository.findById(2L);
		
		Assert.assertTrue(user.isPresent());
		
		user.ifPresent(selectUser->{
			userRepository.delete(selectUser);
		});
		
		Optional<User> deleteUser =userRepository.findById(2L);
		
		Assert.assertFalse(deleteUser.isPresent());
		/*if(deleteUser.isPresent()) {
			System.out.println("데이터 존재: "+deleteUser.get());
		}else{
			System.out.println("테이터 삭제 확인");
		}*/
	}
}
