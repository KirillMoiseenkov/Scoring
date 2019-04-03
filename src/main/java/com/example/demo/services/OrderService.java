package com.example.demo.services;

import com.example.demo.models.Goods;
import com.example.demo.models.Order;
import com.example.demo.repo.GooodsRepo;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Transactional(readOnly = true)
    public Order findById(Long id){

        return orderRepo.findById(id).get();

    }

    @Transactional
    public Order save(Order order){

        return orderRepo.saveAndFlush(order);
    }



}
