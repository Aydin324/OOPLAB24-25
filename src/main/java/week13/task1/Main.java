package week13.task1;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("General message");
        logger.logInfo("This is informal message");
        logger.logError("This is error message");
        logger.logWarning("This is warn message");
    }
}
