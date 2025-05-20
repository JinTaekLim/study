package com.study.study;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

  private final ItemReader<Integer> itemReader;
  private final ItemProcessor<Integer, Integer> itemProcessor;
  private final ItemWriter<Integer> itemWriter;



  @Bean
  public Job customerJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new JobBuilder("customerJob", jobRepository)
        .start(step1(jobRepository, transactionManager))
        .build();
  }

  @Bean
  @JobScope
  public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("step1", jobRepository)
        .<Integer, Integer>chunk(2, transactionManager)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .faultTolerant()
        .skip(Exception.class)
        .skipLimit(5)
        .build();
  }
}
