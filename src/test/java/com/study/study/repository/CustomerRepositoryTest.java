package com.study.study.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.study.study.entity.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository customerRepository;

  private Pageable getPageable(int pageNumber) {
    return PageRequest.of(pageNumber, 10, Sort.by(Sort.Order.desc("id")));
  }

  /*
   * JPA Page 10번 -> 37초112ms
   *
   */
  @RepeatedTest(10)
  @DisplayName("1009999")
  void page_1009999() {
    Pageable pageable = getPageable(1009999);
    Page<Customer> customers = customerRepository.findAll(pageable);
    System.out.println(customers.getContent().size());
  }


  /*
   * JPA Page 10번 -> 36초467ms
   *
   */
  @RepeatedTest(10)
  @DisplayName("999999")
  void page_999999() {
    Pageable pageable = getPageable(999999);
    Page<Customer> customers = customerRepository.findAll(pageable);
    System.out.println(customers.getContent().size());
  }


  /*
   * JPA Page 10번 -> 22초925ms
   *
   */
  @RepeatedTest(10)
  @DisplayName("555555")
  void page_55555() {
    Pageable pageable = getPageable(555555);
    Page<Customer> customers = customerRepository.findAll(pageable);
    System.out.println(customers.getContent().size());
  }

  /*
   * JPA Page 10번 -> 4초568ms
   *
   */
  @RepeatedTest(10)
  @DisplayName("0")
  void page_0() {
    Pageable pageable = getPageable(0);
    Page<Customer> customers = customerRepository.findAll(pageable);
    System.out.println(customers.getContent().size());
  }

}