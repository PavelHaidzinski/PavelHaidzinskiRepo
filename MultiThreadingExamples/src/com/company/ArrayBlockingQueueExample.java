package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(5);

        Thread producer = new Thread(new ProducerArray(queue));
        Thread consumer = new Thread(new ConsumerArray(queue));

        producer.start();
        consumer.start();
    }
}
