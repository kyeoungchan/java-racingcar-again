package racingcar.utils.consts;

public enum ExceptionMessage {
    PREFIX("[ERROR] ");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
