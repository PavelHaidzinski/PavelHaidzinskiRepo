package com.company;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pavel_Haidzinski on 5/26/2017.
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        ProducerLinked producer = new ProducerLinked(queue);
        ObservingConsumer observingConsumer = new ObservingConsumer(queue, producer);
        RemovingConsumer remConsumer = new RemovingConsumer(queue, producer);

        Thread producerThread = new Thread(producer);
        Thread obsConsumerThread = new Thread(observingConsumer);
        Thread remConsumerThread = new Thread(remConsumer);

        producerThread.start();
        obsConsumerThread.start();
        remConsumerThread.start();

    }

}
