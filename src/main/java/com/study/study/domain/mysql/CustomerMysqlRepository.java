package com.study.study.domain.mysql;

import com.study.study.domain.mongo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMysqlRepository extends JpaRepository<Customer, Long> {

}
