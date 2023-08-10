package exception;

import enums.Exception;

public class ApplicationException extends RuntimeException {
    private final String message;

    public ApplicationException(Exception exception) {
        super(exception.getMessage());
        this.message = exception.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
