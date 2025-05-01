package telran.elevator.task;

import telran.elevator.model.Elevator;

public class ElevatorAppl {
    private static final int N_TRUCK = 10_000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator ("v.i. lenin");
        Elevator elevator2 = new Elevator("stalin");
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Truck(N_RACES,CAPACITY,elevator1,elevator2));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Elevator " + elevator1.getName() + " has " + elevator1.getCurrentVolume());
        System.out.println("Elevator " + elevator2.getName() + " has " + elevator2.getCurrentVolume());

    }
}
