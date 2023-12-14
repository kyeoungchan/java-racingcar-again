package racingcar.utils.consts;

public enum ExceptionMessage {
    PREFIX("[ERROR] "),
    INTERNAL_ERROR("Internal Error! "),
    NOT_EXISTING_ROUND("%d round does not exists."),
    ILLEGAL_ROUND_TO_CALCULATE("Illegal Round to calculate Winners"),
    INPUT_ERROR("입력 오류입니다. "),
    INPUT_THINGS_AFTER_COMMA("쉼표 뒤에는 자동차 이름을 입력해주세요!"),
    TOO_LONG_NAME("자동차 이름은 5자 이하여야 합니다."),
    BLANK("자동차 이름은 공백을 사용할 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
