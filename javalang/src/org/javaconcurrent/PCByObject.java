package org.javaconcurrent;

import java.util.PriorityQueue;

/**
 * Created by licheng on 3/15/18.
 */
public class PCByObject {

    private PriorityQueue<Integer> queue = new PriorityQueue<>(10);

    public static void main(String[] args) {
        PCByObject object = new PCByObject();
        Producer producer = object.new Producer();
        Consumer consumer = object.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列为空");
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("取走一个元素,还有：" + queue.size());

                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }
        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 10) {
                        try {
                            System.out.println("队列已经满了");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("向队列中插入一个元素，长度为" + queue.size());
                }
            }
        }
    }
}