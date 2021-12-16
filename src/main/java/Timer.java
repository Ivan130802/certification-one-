import timer.Chronometer;
import timer.Printer;

public class Timer {
    public static void main(String[] args) {
        var chronometer = new Chronometer();
        var secondsPrinter = new Printer(chronometer, "", 1);
        var notifyer5seconds = new Printer(chronometer, "5 second left", 5);
        var notifyer7seconds = new Printer(chronometer, "7 seconds left", 7);

        new Thread(chronometer).start();
        new Thread(secondsPrinter).start();
        new Thread(notifyer5seconds).start();
        new Thread(notifyer7seconds).start();
    }
}
