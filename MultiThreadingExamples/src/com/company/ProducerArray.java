package com.company;

import sun.org.mozilla.javascript.internal.ast.Block;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Pavel_Haidzinski on 5/26/2017.
 */
public class ProducerArray implements Runnable {

    private BlockingQueue queue;

    public ProducerArray(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i< 8; i++){
            System.out.println("Trying to add to queue: String " + i + " and the result was " +
            queue.offer("String" + i));
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
