package singleton;

// Singleton class
class Logger {
    // Private static instance of the same class
    private static Logger instance; //private 이어야 함 

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) { //getInstance() 가 처음 호출되면 logger을 하나 만듦
            instance = new Logger();
        }
        return instance; //처음 호출된 경우가 아니면 이미 생성된 인스턴스를 반환
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Client code
public class Main {
    public static void main(String[] args) { //static이어야지만 getInstance요청 가능
        // Get the only instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Get the same instance of Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verify that both references point to the same instance
        System.out.println(logger1 == logger2); // Output: true(주소가 동일한지 검사) - 동일하면 true 반환되고 true 면 같은 객체 받아온 거임 
    }
}