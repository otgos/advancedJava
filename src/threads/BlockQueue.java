package threads;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue {
    static public int counter = 0;
    public static void main(String[] args) {

        ArrayBlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);
        Produces produces = new Produces(queue);
        Thread producerThread = new Thread(produces);
        producerThread.start();

        Consumer consumer = new Consumer(queue);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

    }
}
class Produces implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Produces(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                queue.put(BlockQueue.counter);
                BlockQueue.counter++;
                System.out.println("Counter value is put to queue.."+BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
                queue.take();
                BlockQueue.counter--;
                System.out.println("Counter value is taken from queue.."+BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
