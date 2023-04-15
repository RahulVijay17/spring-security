package com.spring.security.repository;

import com.spring.security.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards,Long> {
    List<Cards> findByCustomerId(Integer customerId);
}
