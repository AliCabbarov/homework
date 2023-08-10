package enums;

public enum Exception {
    INVALID_OPTION_EXCEPTION("Invalif option");
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
