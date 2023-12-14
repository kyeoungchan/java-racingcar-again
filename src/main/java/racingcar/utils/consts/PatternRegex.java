package racingcar.utils.consts;

public enum PatternRegex {
    END_BY_COMMA(".*,"),
    SPLITTER(",");

    private final String value;

    PatternRegex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
