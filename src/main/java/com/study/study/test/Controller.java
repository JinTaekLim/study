package com.study.study.test;

import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

  @GetMapping("/test")
  public String test() {
    return "test";
  }

  private final TestService testService;

  @PostMapping("insert")
  public Test insert(Long id, String name) {
    return testService.save(id, name);
  }

  @GetMapping("findAll")
  public Iterable<Test> findAll() {
      Iterable<Test> re = testService.findAll();
    return re;
  }

  @GetMapping("findById")
  public Test findById(Long id) {
      Test test = testService.findById(id);
      return test;
  }

  @GetMapping("findByNameContaining")
  public List<Test> findByNameContaining(String name) {
      return testService.findByNameContaining(name);
  }

  @DeleteMapping("delete")
  public void delete(Long id) {
    testService.delete(id);
  }

  @PatchMapping("update")
  public void update(Long id, String name) {
    testService.update(id, name);
  }

  @DeleteMapping("deleteAll")
  public void deleteAll() {
    testService.deleteAll();
  }
}
