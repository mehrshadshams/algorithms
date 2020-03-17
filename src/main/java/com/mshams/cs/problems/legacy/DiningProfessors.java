package com.mshams.cs.problems.legacy;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningProfessors {
  private final Semaphore semaphore;
  private final Professor[] professors;
  private final Random random = new Random(System.currentTimeMillis());

  public DiningProfessors(int n) {
    semaphore = new Semaphore(n);
    professors = new Professor[n];
    Chopstick[] chopsticks = new Chopstick[n];
    for (int i = 0; i < n; i++) {
      chopsticks[i] = new Chopstick();
    }
    for (int i = 0; i < n; i++) {
      int left = i - 1;
      if (left < 0) {
        left = n - 1;
      }
      professors[i] = new Professor(i, chopsticks[left], chopsticks[(i + 1) % n]);
    }
    for (int i = 0; i < n; i++) {
      new Thread(professors[i]).start();
    }
  }

  public static void main(String[] args) {
    DiningProfessors d = new DiningProfessors(5);

    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public class Chopstick {
    private final Lock lock = new ReentrantLock();

    public boolean pickup() {
      return lock.tryLock();
    }

    public void putdown() {
      lock.unlock();
    }
  }

  public class Professor implements Runnable {

    private final int number;
    private final Chopstick left;
    private final Chopstick right;

    public Professor(int i, Chopstick left, Chopstick right) {
      this.number = i;
      this.left = left;
      this.right = right;
    }

    @Override
    public void run() {
      while (true) {
        try {
          System.out.println("Professor " + number + " waiting for chopstick.");
//                    try {
//                        semaphore.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

          left.pickup();
          right.pickup();

          System.out.println("Professor " + number + " eating.");
          try {
            Thread.sleep(random.nextInt(10000));
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          System.out.println("Professor " + number + " releasing chopstick.");

          right.putdown();
          left.putdown();
        } finally {
          //semaphore.release();
        }
      }
    }

    private boolean pickup() {
      if (!left.pickup()) {
        return false;
      }
      if (!right.pickup()) {
        left.putdown();

        return false;
      }
      return true;
    }
  }
}
