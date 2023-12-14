package racingcar.view.validator;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.consts.ExceptionMessage;

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
    @MethodSource("generateIllegalData")
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

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.arguments("aaaa, bbbb, ccc", List.of("aaaa", "bbbb", "ccc")),
                Arguments.arguments("    aaaa    ,   bbbb  , ccc ", List.of("aaaa", "bbbb", "ccc")),
                Arguments.arguments("aa aa , bb bb , cc", List.of("aa aa", "bb bb", "cc"))
        );
    }

    static Stream<Arguments> generateIllegalData() {
        return Stream.of(
                Arguments.arguments("aaaa, bbbb,"),
                Arguments.arguments("    aaaa    ,   bbbb  , "),
                Arguments.arguments("aa aa , bb bb ,    ")
        );
    }
}