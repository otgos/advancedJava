package threads;
class MyTaskWithoutThread{
    void executeTask(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int doc =1; doc<=10; doc++){
            System.out.println("@@Printing Document # "+doc +" Printer 2");

        }
    }
}

//My task IS-A Thread
class MyTaskWithThread extends Thread {
    @Override
    public void run(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int doc =1; doc<=10; doc++){
            System.out.println("@@Printing Document # "+doc +" Printer 3");

        }
    }

}

public class MyThread03 {
    public static void main(String[] args) {
        long noThreadTimeStarted  = System.currentTimeMillis();
        System.out.println("========== Application Started Without Thread===========");

        MyTaskWithoutThread myTaskWithoutThread = new MyTaskWithoutThread();
        myTaskWithoutThread.executeTask();
        for (int doc =1; doc<=10; doc++){

            System.out.println("Printing Document # "+doc+" Printer 1");

        }
        System.out.println("========== Application Ended Without Thread===========");
        long noThreadTimeEnded  = System.currentTimeMillis();

        long threadTimeStarted  = System.currentTimeMillis();
        System.out.println("Time Elapsed for without thread is :"+(noThreadTimeEnded-noThreadTimeStarted));
        System.out.println("========== Application Started With Thread===========");
        MyTaskWithThread myTaskWithThread = new MyTaskWithThread();
        myTaskWithThread.start();
        for (int doc =1; doc<=10; doc++){

            System.out.println("Printing Document # "+doc+" Printer 4");

        }
        System.out.println("========== Application Ended With Thread===========");
        try {
            myTaskWithThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long threadTimeEnded  = System.currentTimeMillis();
        System.out.println("Time elapsed for thread : " +(threadTimeEnded-threadTimeStarted));
    }
}
