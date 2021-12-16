package timer;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Chronometer implements Runnable {

    private long currentTime;

    @Override
    public void run() {
        var startTime = System.nanoTime();
        while (true) {
            try {
                sleep(1000);
                synchronized (this) {
                    long now = System.nanoTime();
                    currentTime = TimeUnit.NANOSECONDS.toSeconds(now - startTime);
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getCurrentTime() {
        return currentTime;
    }
}
