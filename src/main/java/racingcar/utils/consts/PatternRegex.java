package racingcar.utils.consts;

public enum PatternRegex {
    END_BY_COMMA(".*,"),
    SPLITTER(","),
    NUMBER_LEAST_ONE_DIGIT("\\d+");

    private final String value;

    PatternRegex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
