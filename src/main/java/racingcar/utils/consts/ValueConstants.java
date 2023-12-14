package racingcar.utils.consts;

public enum ValueConstants {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9),
    MOVE_STANDARD(4),
    NAME_SIZE_LIMIT(5),
    SMALLEST_NATURAL_NUMBER(1),
    MAXIMUM_ROUND(20),
    DIGITS_ADDED_COMMA(2);


    private final int value;

    ValueConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
