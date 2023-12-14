package racingcar.view.validator;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("자동차 이름을 입력하면 쉼표를 기준으로 나누고, 앞뒤 공백은 자동으로 제거해준다.")
    void parseToStrings(String namesData, List<String> carNames) {
        assertThat(inputValidator.parseToStrings(namesData))
                .isEqualTo(carNames);
    }

    @ParameterizedTest
    @MethodSource("generateEndByCommaData")
    @DisplayName("쉼표로 끝나면 예외를 발생시킨다.")
    void validateEndByComma(String namesData) {
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.PREFIX.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.INPUT_ERROR.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.INPUT_THINGS_AFTER_COMMA.getMessage());
    }

    @ParameterizedTest
    @MethodSource("generateBlankData")
    @DisplayName("쉼표로 끝나면 예외를 발생시킨다.")
    void validateBlankData(String namesData) {
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.PREFIX.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.INPUT_ERROR.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToStrings(namesData))
                .hasMessageContaining(ExceptionMessage.BLANK.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1", "2, 2", "9999, 9999", "9999999, 9999999"})
    @DisplayName("숫자로 입력한다면 InputValidator 는 예외를 발생시키지 않는다.")
    void parseToInt(String roundData, int value) {
        assertThat(inputValidator.parseToInt(roundData))
                .isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백을 입력하면 예외가 발생한다.")
    void validateEmptyRound(String roundData) {
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.PREFIX.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.INPUT_ERROR.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.BLANK.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"abc", "가나다", "9숫자"})
    @DisplayName("공백을 입력하거나 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    void validateNotNumberRound(String roundData) {
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.PREFIX.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.INPUT_ERROR.getMessage());
        assertThatThrownBy(() -> inputValidator.parseToInt(roundData))
                .hasMessageContaining(ExceptionMessage.INPUT_ONLY_NUMBER.getMessage());
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.arguments("aaaa, bbbb, ccc", List.of("aaaa", "bbbb", "ccc")),
                Arguments.arguments("    aaaa    ,   bbbb  , ccc ", List.of("aaaa", "bbbb", "ccc")),
                Arguments.arguments("aa aa , bb bb , cc", List.of("aa aa", "bb bb", "cc"))
        );
    }

    private static Stream<Arguments> generateEndByCommaData() {
        return Stream.of(
                Arguments.arguments("aaaa, bbbb,"),
                Arguments.arguments("    aaaa    ,   bbbb  , "),
                Arguments.arguments("aa aa , bb bb ,    "),
                Arguments.arguments("aa aa ,  ,    ")
        );
    }

    private static Stream<Arguments> generateBlankData() {
        return Stream.of(
                Arguments.arguments(", bbbb"),
                Arguments.arguments("    aaaa    ,   ,bbbb  "),
                Arguments.arguments("aa aa , bb bb ,   cccc, ,ddd "),
                Arguments.arguments(", , aa aa")
        );
    }
}