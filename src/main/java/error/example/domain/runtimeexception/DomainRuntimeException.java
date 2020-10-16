package error.example.domain.runtimeexception;

public class DomainRuntimeException extends RuntimeException {

    public DomainRuntimeException(String message) {
        super(message);
    }
}
