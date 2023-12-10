package racingcar.utils.consts;

public enum ValueConstants {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9),
    MOVE_STANDARD(4);


    private final int value;

    ValueConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
