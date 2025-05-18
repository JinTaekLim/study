package com.study.study.test;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestRepository testRepository;

  public Test save(Long id, String name) {
    Test test = Test.builder().id(id).name(name).build();
    return testRepository.save(test);
  }

  public Test findById(Long id) {
    return testRepository.findById(id).orElse(null);
  }

  public Iterable<Test> findAll() {
    return testRepository.findAll();
  }

  public void delete(Long id) {
    testRepository.deleteById(id);
  }

  public void update(Long id, String name) {
    Test test = testRepository.findById(id).get();
    test.updateName(name);
    testRepository.save(test);
  }

  public void deleteAll() {
    testRepository.deleteAll();
  }

  public List<Test> findByNameContaining(String name) {
    return testRepository.findByNameContaining(name);
  }

}
