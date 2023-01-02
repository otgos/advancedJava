package threads;

public class MultiThreading02 {
    public static int counter = 0;
    //if you use single data different threads, you need to synchronize the method, otherwise you will get
    //different results..
    //To synchronize method use synchronized keyword before or after access modifier
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 is completed...");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 is completed...");
            }
        });
        thread2.start();
    }
}
class Counter{
    synchronized public static void count(){
        for(int i =1; i<=1000; i++){
            MultiThreading02.counter++;
        }
        System.out.println("Counter value: "+MultiThreading02.counter);
    }
}