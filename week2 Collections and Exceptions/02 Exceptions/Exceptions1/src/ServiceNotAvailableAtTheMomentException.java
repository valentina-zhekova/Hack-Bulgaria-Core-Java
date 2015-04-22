
public class ServiceNotAvailableAtTheMomentException extends Exception {
    // for now is actually a bad looking Exception class... refactor later!!!
    
    public String message() {
        return "Please check your network connection, firewall and router.\n";
    }
}
