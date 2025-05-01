package telran.timer.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable {
    private int clockPeriod = 1;

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(clockPeriod * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().getName() + "(aka Timer) timer say bye,bye");
                break;
                ////throw new RuntimeException(e);
            }
        }
    }
}