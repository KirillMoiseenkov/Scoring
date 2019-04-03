package com.example.demo;

import com.example.demo.models.Goods;
import com.example.demo.repo.GooodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	@Autowired
	GooodsRepo gooodsRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Goods goods = new Goods();

		goods.setName("first");

	}




}
