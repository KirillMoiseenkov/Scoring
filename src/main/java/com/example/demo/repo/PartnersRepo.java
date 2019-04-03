package com.example.demo.repo;

import com.example.demo.models.Partners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnersRepo extends JpaRepository<Partners, Long> {
}
