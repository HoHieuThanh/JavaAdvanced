package exception;

public class InvalidOrderIdException extends RuntimeException{
    public InvalidOrderIdException(String message) {
        super(message);
    }
}
