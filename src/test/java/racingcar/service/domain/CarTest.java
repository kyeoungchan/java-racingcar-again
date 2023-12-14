package racingcar.service.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.vo.CarInfo;

import static org.assertj.core.api.Assertions.assertThat;

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
}