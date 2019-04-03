package com.example.demo.repo;

import com.example.demo.models.Order;
import com.example.demo.models.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderGoodsRepo extends JpaRepository<OrderGoods, Long> {


        List<OrderGoods> findOrderGoodsByOrders(Order order);

        List<OrderGoods> findOrderGoodsByOrdersId(Long id);

}
