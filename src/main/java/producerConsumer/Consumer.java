package producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        var i = 0;
        for (String word : queue) {
            i++;
            System.out.println("Word No" + i + ": " + word);
        }
    }
}
