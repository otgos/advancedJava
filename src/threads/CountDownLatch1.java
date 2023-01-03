package threads;
//note: countdownlatch is used to make sure that a task waits fo threads before it starts

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        AssignTaskThread first = new AssignTaskThread(10000, latch, "Team-1");
        AssignTaskThread second = new AssignTaskThread(20000, latch, "Worked-2");
        AssignTaskThread third = new AssignTaskThread(30000, latch, "Worked-3");
        AssignTaskThread fourth = new AssignTaskThread(40000, latch, "Worked-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" has finished..");
        System.out.println("Program is ready to send for testing..");
    }
}
class AssignTaskThread extends Thread{
    private int delay;
    private CountDownLatch latch;
    public AssignTaskThread(int delay, CountDownLatch latch, String name){
        super(name);
        this.delay = delay;
        this.latch = latch;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            // there will be some task for worker thread
            System.out.println(ThreadCreator.currentThread().getName()+" finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }
}
