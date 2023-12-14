package racingcar.service.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.vo.CarInfo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"false, 0", "true, 1", "true, 1"})
    @DisplayName("RandomEngine 이 MovingStatus 로 true 를 주면 움직이고, false면 움직이지 않는다.")
    void playOneRound(boolean movingStatus, int newPosition) {
        int round = 1;
        Car car = new Car("kyeou");
        CarInfo carInfo = car.playOneRound(round, movingStatus);

        assertThat(carInfo.name()).isEqualTo("kyeou");
        assertThat(carInfo.currentPosition()).isEqualTo(newPosition);
        assertThat(carInfo.currentRound()).isEqualTo(round);
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 1", "true, 2", "true, 3"})
    @DisplayName("RandomEngine 이 true 를 줄수록 position 의 값은 중첩돼서 올라간다.")
    void playOneRound2(boolean movingStatus, int round) {
        Car car = new Car("aaa");
        for (int i = 0; i < round; i++) {
            int position = i + 1;
            CarInfo carInfo = car.playOneRound(i, movingStatus);
            assertThat(carInfo.currentPosition()).isEqualTo(position);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"aaaaa", "bbb", "cccc"})
    @DisplayName("5자 이하의 자동차 이름이면 아무런 예외가 발생하지 않는다.")
    void validateCarNames(String carName) {
        assertThatNoException().isThrownBy(() -> new Car(carName));
    }

    @ParameterizedTest
    @CsvSource(value = {"aaaaaa", "bbbbbbb"})
    @DisplayName("5자 초과의 자동차 이름이면 아무런 예외가 발생한다.")
    void validateLongCarNames(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(carName))
                .hasMessageContaining(ExceptionMessage.PREFIX.getMessage());
        assertThatThrownBy(() -> new Car(carName))
                .hasMessageContaining(ExceptionMessage.INPUT_ERROR.getMessage());
        assertThatThrownBy(() -> new Car(carName))
                .hasMessageContaining(ExceptionMessage.TOO_LONG_NAME.getMessage());
    }

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("aaaaa", "bbb", "ccc")),
                Arguments.arguments(List.of("aaa", "aaa", "aaa"))
        );
    }

}