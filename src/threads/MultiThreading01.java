package threads;

public class MultiThreading01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        CounterWithoutMultiThread counter1= new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2= new CounterWithoutMultiThread(2);
        counter1.countMe();
        System.out.println("------------------");
        counter2.countMe();
        long endTime = System.currentTimeMillis();
        System.out.println("Without multiThread: "+(endTime-startTime));
        System.out.println("==========================");
        long startTime2 = System.currentTimeMillis();
        CounterWithtMultiThread counter3= new CounterWithtMultiThread(1);
        CounterWithtMultiThread counter4= new CounterWithtMultiThread(2);
        counter3.start();

        System.out.println("------------------");

        counter4.start();

        //waits for the thread to die
        counter3.join();
        counter4.join();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Witht multiThread: "+(endTime2-startTime2));
    }
}
class CounterWithoutMultiThread{

    private int threadNum;
    public CounterWithoutMultiThread(int threadNum){
        this.threadNum = threadNum;
    }
    public void countMe() throws InterruptedException {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        Thread.sleep(50);
        for(int i = 1; i<=10; i++){
            System.out.println("i"+i+ " Thread number: "+threadNum);
        }
    }

}

class CounterWithtMultiThread extends Thread{
    private int threadNum;
    public CounterWithtMultiThread(int threadNum){
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void countMe() throws InterruptedException {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        Thread.sleep(50);
        for(int i = 1; i<=10; i++){
            System.out.println("i"+i+ " Thread number: "+threadNum);
        }
    }

}