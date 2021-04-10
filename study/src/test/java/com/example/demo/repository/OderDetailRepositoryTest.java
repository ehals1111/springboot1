package com.example.demo.repository;




import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.OrderDetail;


public class OderDetailRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private OderDetailRepository orderDetailRepository;
	
	@Test
	public void create() { 
		OrderDetail orderDetail= new OrderDetail();
		
		
		orderDetail.setStatus("WAITING");
		orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
		//어떤 사람?
		//orderDetail.setOrderGroupId(1L);
		//어떤 상품?
		orderDetail.setItemId(1L);
		orderDetail.setCreatedAt(LocalDateTime.now());
		orderDetail.setCreatedBy("AdminServer");
		
		OrderDetail newOderDetail= orderDetailRepository.save(orderDetail);
		Assert.assertNotNull(newOderDetail);
		//System.out.println("1");
	} 
}
