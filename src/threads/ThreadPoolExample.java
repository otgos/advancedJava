package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        //creating single thread for one task
        /*
        Thread thread = new Thread(new Task());
        thread.setName("Task thread");
        thread.start();
        System.out.println("Thread Name: "+Thread.currentThread().getName());

         */
        //suppose we have now 10 tasks
        /*
        for(int task =0; task<10; task ++){ // each time it will create new thread with new instance of task
            Thread thread = new Thread(new Task());
            thread.start();
        }
        System.out.println("Thread Name: "+Thread.currentThread().getName());
         */
        //what if we have 100 tasks then 100 threads would be created

        // to get ideal processors
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(4);
        //having too many threads at the same time is not good idea especially your thread is CPU intensive operation
        //encryption/decryption or video transcoding
        // so if you have CPU of 4 cores, then you need to run 4 threads at the same time...
        //submit the tasks for execution
        for(int i = 0; i<100; i++){
            service.execute(new Task());
        }
        service.shutdown(); //other wise threads will be running
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }

}
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
}
