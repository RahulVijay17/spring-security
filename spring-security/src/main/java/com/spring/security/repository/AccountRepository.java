package com.spring.security.repository;

import com.spring.security.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(Integer customerId);
}
