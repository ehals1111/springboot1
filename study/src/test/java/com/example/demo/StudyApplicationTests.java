package com.example.demo;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class) //repository nullpointexception 오류.. 해결..
@SpringBootTest
public class StudyApplicationTests {

	@Test 
	void contextLoads() {
	}

}
