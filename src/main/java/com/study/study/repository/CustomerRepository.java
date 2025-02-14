package com.study.study.repository;

import com.study.study.entity.Customer;
import com.study.study.entity.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Page<Customer> findByStatus(CustomerStatus status, Pageable pageable);
  Page<Customer> findAll(Pageable pageable);

}
