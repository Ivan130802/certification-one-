import producerConsumer.Consumer;
import producerConsumer.Producer;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        var queue = new LinkedBlockingQueue<String>();
        var producer = new Producer(queue);
        var consumer = new Consumer(queue);

        var exec = Executors.newSingleThreadExecutor();
        exec.submit(producer);
        exec.submit(consumer);

        exec.shutdown();
    }
}
