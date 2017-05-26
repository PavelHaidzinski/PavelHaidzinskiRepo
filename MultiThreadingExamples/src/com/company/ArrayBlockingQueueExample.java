package com.company;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(5);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
