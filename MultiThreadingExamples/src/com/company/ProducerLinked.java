package com.company;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pavel_Haidzinski on 5/26/2017.
 */
public class ProducerLinked implements Runnable {

    private LinkedBlockingQueue queue;
    private boolean running;

    public ProducerLinked(LinkedBlockingQueue queue){
        this.queue = queue;
        running = true;
    }

    public boolean isRunning(){
        return running;
    }

    @Override
    public void run() {
        for(int i =0; i < 15; i ++){
            String element = "String" + i;
            try{
                queue.put(element);
                System.out.println("P\tAdding element: " + element);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("P Completed.");
        running = false;
    }
}
