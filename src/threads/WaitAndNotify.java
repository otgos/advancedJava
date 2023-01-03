package threads;

public class WaitAndNotify {
    static public int balance = 0;

    public static void main(String[] args) {

        WaitAndNotify obj = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        System.out.println(thread1.getName());
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //to see clearly what is happening
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(20);
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();

    }

    public void withdraw(int amount){
        synchronized (this){
            if(balance<=0 || balance<amount){
                System.out.println("Waiting for for the amount to update...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            balance = balance - amount;
            System.out.println("Withdraw is successful. The current balance is : "+balance);
        }


    }
    public void deposit(int amount){
        balance = balance +amount;
        System.out.println("The amount is deposited. the current balance is : "+balance );
        //TODO : add synchronized keyword
        synchronized (this){
            notify();
        }
    }
}
