package com.company;

import sun.awt.image.ImageWatched;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pavel_Haidzinski on 5/26/2017.
 */
public class RemovingConsumer implements Runnable {

    private LinkedBlockingQueue queue;
    private ProducerLinked producer;

    public RemovingConsumer(LinkedBlockingQueue queue, ProducerLinked producer){
        this.queue = queue;
        this.producer = producer;
    }

    @Override
    public void run() {
            while(producer.isRunning()){
                try{
                    System.out.println("RC\tRemoving element: " + queue.take());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        System.out.println("RC completed.");
    }

}
