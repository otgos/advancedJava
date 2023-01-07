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

    // para çekme methodu
    public void withdraw(int amount) {
        synchronized (this) {
            if(balance<=0 || balance<amount) {

                try {
                    System.out.println("Waiting for the amount to update");
                    wait(); // thredi bekletiyoruz, notify gelesiye kadar,
                    // aynı obje içindeki wait ve notify dan bahsediyoruz burada
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // wait işlemi bittikten sonra , para çekim işlemi gerçekleşebilir
        balance=balance-amount;
        System.out.println("Withdrawal is successful. The current balance is "+balance);
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
