import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private final SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private static Logger instance;

    private Logger() {
    }

    public void log(String msg) {
        Date date = new Date();
        System.out.println("[" + formater.format(date) + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
