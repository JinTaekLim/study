package com.study.study.test;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test")
@Builder
@Data
public class Test {

  @Id
  private Long id;

  private String name;


  public void updateName(String name) {
    this.name = name;
  }

}
