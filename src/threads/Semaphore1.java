package threads;

import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        Thread.sleep(2000);
        System.out.println("Available parking spavce is "+ semaphore.availablePermits());

        Car car1= new Car("Car1", semaphore);
        car1.start();
        Car car2= new Car("Car2", semaphore);
        car2.start();
        Car car3= new Car("Car3", semaphore);
        car3.start();
        Car car4= new Car("Car4", semaphore);
        car4.start();
        Car car5= new Car("Car5", semaphore);
        car5.start();
        Car car6= new Car("Car6", semaphore);
        car6.start();

    }
}
class Car extends Thread{
   private String name;
   private Semaphore semaphore;

   //constr
    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(name +" is trying to park...");
            semaphore.acquire(); // is trying to get permit to acquire
            System.out.println(name+" parked...");
            //suppose that each car can be parked for 4 hours
            for (int i=1; i<=4; i++){
                System.out.println(name+" is parked for "+i+" hours");
                Thread.sleep(5000);
            }
            System.out.println(name+" left the parking...");
            semaphore.release(); //
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
