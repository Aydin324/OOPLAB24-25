package week13.task1;

public class Logger {
    private static Logger logger;

    private Logger(){
        System.out.println("Logger instantiated;");
    }

    public static Logger getInstance(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message){
        System.out.println("General message: " + message);
    }
    public void logInfo(String message){
        System.out.println("Info: " + message);
    }
    public void logWarning(String message){
        System.out.println("Warning: " + message);
    }
    public void logError(String message){
        System.out.println("Error: " + message);
    }

}
