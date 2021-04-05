package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderDetail;

@Repository
public interface OderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
