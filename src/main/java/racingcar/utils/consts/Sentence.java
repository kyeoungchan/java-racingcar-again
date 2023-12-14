package racingcar.utils.consts;

public enum Sentence {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND("시도할 회수는 몇회인가요?"),
    SEPARATOR(" : "),
    POSITION_EXPRESSION("-"),
    WINNERS_GUIDE("최종 우승자"),
    SEPARATOR_TO_LIST(", ");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
