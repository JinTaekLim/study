package com.study.study;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class CustomItemReader implements ItemReader<Integer>, ItemStream {

  private int count = 1;

  private int index = 30;
  @Override
  public Integer read() throws Exception {
    System.out.println("우왕" + count);
    if (count <= index) {
      if (count > 10 && count < 20) throw new Exception("오류 발생");
      return count++;
    } else {
      return null;
    }
  }

  @Override
  public void open(ExecutionContext executionContext) throws ItemStreamException {
    if (executionContext.containsKey("count")) {
      this.count = executionContext.getInt("count");
    }
  }

  @Override
  public void update(ExecutionContext executionContext) throws ItemStreamException {
    executionContext.putInt("count", this.count);
  }

}
