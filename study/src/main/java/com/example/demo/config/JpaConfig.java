package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정파일에 대한것이 들어간다고 선언
@EnableJpaAuditing //갘시자를 활성화 시키겠다 
public class JpaConfig {

} 
 