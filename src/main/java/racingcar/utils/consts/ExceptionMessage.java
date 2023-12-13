package racingcar.utils.consts;

public enum ExceptionMessage {
    PREFIX("[ERROR] "),
    NOT_EXISTING_ROUND("%d round does not exists."),
    ILLEGAL_ROUND_TO_CALCULATE("Illegal Round to calculate Winners");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
