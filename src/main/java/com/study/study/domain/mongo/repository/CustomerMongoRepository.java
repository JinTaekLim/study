package com.study.study.domain.mongo.repository;

import com.study.study.domain.mongo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerMongoRepository extends JpaRepository<Customer, Long> {

}
