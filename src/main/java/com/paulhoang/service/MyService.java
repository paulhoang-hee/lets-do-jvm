package com.paulhoang.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class MyService {

  private static final int LOOP_TIMES = 1_000_000;
  private Queue<Long> store;

  @PostConstruct
  public void init() {
    store = new ConcurrentLinkedQueue<>();
    generateRandomNumbers();
  }

  public Long someVeryComputeIntensiveMethod() {
    generateRandomNumbers();
    Long sum = new Long(0);
    for (Long aLong : store) {
      sum += aLong;
    }
    return sum;
  }

  private void generateRandomNumbers() {
    Random r = new Random();
    for (int i = 0; i < LOOP_TIMES; i++) {
      store.add(r.nextLong());
    }
  }
}
