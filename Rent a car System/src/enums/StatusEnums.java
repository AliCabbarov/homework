package enums;

public enum StatusEnums {
    SUCCESS("Success"),
    INVALID("Invalid"),
    MISTAKE("Mistake");
    private final String message;

    StatusEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
