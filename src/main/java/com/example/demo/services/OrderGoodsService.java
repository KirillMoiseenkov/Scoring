package com.example.demo.services;

import com.example.demo.models.Order;
import com.example.demo.models.OrderGoods;
import com.example.demo.repo.OrderGoodsRepo;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrderGoodsService {


    @Autowired
    OrderGoodsRepo orderGoodsRepo;

    @Transactional
    public OrderGoods findById(Long id){

        return orderGoodsRepo.findById(id).get();

    }

    @Transactional
    public OrderGoods save(OrderGoods orderGoods){



        return orderGoodsRepo.saveAndFlush(orderGoods);

    }

    @Transactional(readOnly = true)
    public List<OrderGoods> findAll(){return orderGoodsRepo.findAll(); }


}
