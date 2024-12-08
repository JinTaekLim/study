package com.study.study.domain.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMysqlRepository extends JpaRepository<Customer, Long> {

}
