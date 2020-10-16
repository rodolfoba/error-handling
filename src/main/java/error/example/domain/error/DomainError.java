package error.example.domain.error;

public abstract class DomainError {

    private final String message;

    public DomainError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
