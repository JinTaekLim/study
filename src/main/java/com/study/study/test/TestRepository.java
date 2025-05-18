package com.study.study.test;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TestRepository extends ElasticsearchRepository<Test,Long> {

  List<Test> findByNameContaining(String name);
}
