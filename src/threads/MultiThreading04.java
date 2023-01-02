package threads;

public class MultiThreading04 {
    public static void main(String[] args) {
        Bracket brackets = new Bracket();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<7; i++ ){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<7; i++ ){
                    brackets.generateBrackets();
                }
            }
        });
        thread2.start();
        System.out.println("Duration of synchronized method: ");
    }
}

class Bracket{
     public void  generateBrackets(){
        //monitor object
        synchronized (this){
            for(int i =1; i<=10; i++){
                if(i<=5){
                    System.out.print("[");
                }else{
                    System.out.print("]");
                }
            }
            System.out.println("");
        }
        for(int i = 0; i<50; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}