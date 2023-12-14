package racingcar.utils.consts;

public enum ExceptionMessage {
    PREFIX("[ERROR] "),
    INTERNAL_ERROR("Internal Error! "),
    NOT_EXISTING_ROUND("%d round does not exists."),
    ILLEGAL_ROUND_TO_CALCULATE("Illegal Round to calculate Winners"),
    INPUT_ERROR("입력 오류입니다. "),
    INPUT_THINGS_AFTER_COMMA("쉼표 뒤에는 자동차 이름을 입력해주세요!"),
    TOO_LONG_NAME("자동차 이름은 5자 이하여야 합니다."),
    BLANK("공백을 입력할 수 없습니다."),
    NOT_NATURAL_NUMBER("1 이상의 자연수를 입력해주세요!"),
    EXCEEDS_MAXIMUM_ROUND("20 이하의 라운드로 입력해주세요!"),
    INPUT_ONLY_NUMBER("숫자로만 입력해주시기 바랍니다!");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
