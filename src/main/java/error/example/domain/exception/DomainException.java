package error.example.domain.exception;

public abstract class DomainException extends Exception {

    public DomainException(String message) {
        super(message);
    }
}
