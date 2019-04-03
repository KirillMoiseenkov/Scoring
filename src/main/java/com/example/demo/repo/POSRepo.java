package com.example.demo.repo;

import com.example.demo.models.POS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POSRepo extends JpaRepository<POS, Long> {
}
