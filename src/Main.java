import di.Injector;
import handler.ConsoleHandler;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handle();
    }


}
