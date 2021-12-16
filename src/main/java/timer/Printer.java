package timer;

import java.util.Objects;

public class Printer implements Runnable {
    private final Chronometer chronometer;
    private final String msg;
    private final int delay;

    public Printer(Chronometer chronometer, String msg, int delay) {
        this.chronometer = chronometer;
        this.msg = msg;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (chronometer) {
                try {
                    chronometer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var currentTime = chronometer.getCurrentTime();

                if (chronometer.getCurrentTime() % delay == 0) {
                    var currentMsg = Objects.equals(msg, "") ? currentTime : msg;
                    System.out.println(currentMsg);
                }
            }
        }
    }
}
