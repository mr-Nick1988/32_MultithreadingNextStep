package telran.timer.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        // thread.setDaemon(true);
        thread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("enter time interval, or press q for exit");
            String str = reader.readLine();
            if ("q".equalsIgnoreCase(str)) {
                //   thread.stop();
                thread.interrupt();
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println(Thread.currentThread().getName() + "Thread finished");
    }
}
