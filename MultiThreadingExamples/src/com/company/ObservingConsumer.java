package com.company;

import com.oracle.jrockit.jfr.Producer;
import sun.awt.image.ImageWatched;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pavel_Haidzinski on 5/26/2017.
 */
public class ObservingConsumer implements Runnable {

    private LinkedBlockingQueue queue;
    private ProducerLinked producer;

    public ObservingConsumer(LinkedBlockingQueue queue, ProducerLinked producer){
        this.queue = queue;
        this.producer = producer;
    }

    @Override
    public void run() {
        while(producer.isRunning()){
            System.out.println("OC\tElements right now: " + queue);
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("OC Completed");
        System.out.println("Final elements in the queue: " + queue);
    }
}
