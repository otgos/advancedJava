package threads;

//class MyTask{
//    void executeTask(){
//        for (int doc =1; doc<=10; doc++){
//            System.out.println("@@Printing Document # "+doc +" Printer 2");
//
//        }
//    }
//}
//My task IS-A Thread
//class MyTask extends Thread {
//    @Override
//    public void run(){
//        for (int doc =1; doc<=100; doc++){
//            System.out.println("@@Printing Document # "+doc +" Printer 2");
//
//        }
//    }
//
//}

class YourThreads extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("It is custom thread...");
    }
}

class CA{

}

class MyTask extends CA implements Runnable{

    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int doc =1; doc<=10; doc++){
            System.out.println("@@Printing Document # "+doc +" Printer 2");

        }
    }
}

public class MyThread {

    //main method represents main thread
    public static void main(String[] args) {
        //whatever we write in here will be executed by main thread
        //threads always execute the jobs in a sequence
        //Execution Context


        System.out.println("===Application started===");
        // some code to print the document


        //job2
//        MyTask task = new MyTask(); //Child thread or Worker thread
////        myTask.executeTask();
//        task.start(); //start shall internally execute run method

        Runnable r = new MyTask();
        Thread task  = new Thread(r);
        task.start();

        //3rd way of creating thread
        Thread thread3= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread created with the anonymous way");
            }
        });
        //start thread
        thread3.start();

        //4th way using lambda

        Thread thread5 = new Thread(()->{
            System.out.println("Thread created with lambda");
        });
        thread5.start();
        ///Bekir beyden
        YourThreads threads = new YourThreads();
        threads.setName("Thread 1");
        //threads.run() // will call the run method
        threads.start();

        //Till Job2 is not finished , below written jobs are waiting and are not executed.. because of sequentiality
        //In case Job2 is a long running operation, i e several documents are suppose to be printed
        //In such cases we use OS/JVM shall give message that app is not respondin...


        //Now, main and MyTask are executing both parallely or concurrently.
        //job3
        for (int doc =1; doc<=10; doc++){

            System.out.println("Printing Document # "+doc+" Printer 1");

        }

        //job4
        System.out.println("===Application ended===");

    }
}
