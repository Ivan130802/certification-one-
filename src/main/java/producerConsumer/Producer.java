package producerConsumer;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final Parser parser = new ParserViaScanner();

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        var file = new File("src/main/java/producerConsumer/voyna.txt");

        ArrayList<String> words = parser.parse(file);

        for (String word : words) {
            try {
                queue.put(word);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
