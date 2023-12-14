package racingcar.service.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RandomEngineTest {
    private final RandomEngine randomEngine = new RandomEngine();

    @ParameterizedTest
    @CsvSource(value = {"4, true", "0, false", "3, false", "9, true"})
    @DisplayName("랜덤 값이 4 이상이면 true 를 반환하고, 4 이하면 false를 반환한다.")
    void ifMove(int engineValue, boolean movingStatus) {
        assertRandomNumberInRangeTest(() -> {
            boolean result = randomEngine.ifMove();
            assertThat(result).isEqualTo(movingStatus);
        }, engineValue);
    }
}