package com.example.demo.services;

import com.example.demo.models.Goods;
import com.example.demo.repo.GooodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GoodsServices {

    @Autowired
    GooodsRepo gooodsRepo;

    @Transactional(readOnly = true)
    public Goods findById(Long id){

        return gooodsRepo.findById(id).get();

    }
    @Transactional
    public Goods save(Goods goods){

        return gooodsRepo.saveAndFlush(goods);
    }

    @Transactional(readOnly = true)
    public List<Goods> findAll(){return gooodsRepo.findAll();}


}
