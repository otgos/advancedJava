package threads;
class Printer{
    //synchronized void printDocument (int numOfCopies, String docName){
    void printDocument (int numOfCopies, String docName){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i<=numOfCopies; i++){
            System.out.println(">>Printing "+docName +" "+i);
        }
    }
}
class MyPrinterThread extends Thread{
    Printer pRef;
    MyPrinterThread(Printer p){
        pRef = p;
    }
    @Override
    public void run() {
        synchronized (pRef){
            pRef.printDocument(10, "JohnsProfile.pdf");
        }
    }
}

class YourPrinterThread extends Thread{
    Printer pRef;
    YourPrinterThread(Printer p){
        pRef = p;
    }
    @Override
    public void run() {
        synchronized (pRef){
            pRef.printDocument(10, "KevinsProfile.pdf");
        }
    }
}

public class MyThread02 {
    public static void main(String[] args) {
        System.out.println("=====Application Started ==========");

        //We have only 1 single printer object of Printer
        Printer printer = new Printer();
        //Scenario is that we have multiple thread working on the same Printer
        //If multiple Threads are going to work on the same single Object we must Synchronize Them
        MyPrinterThread thread1 = new MyPrinterThread(printer);
        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        YourPrinterThread thread2 = new YourPrinterThread(printer);
        thread2.start();
        System.out.println("=====Application Ended ==========");
    }
}
