package racingcar.service.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.vo.CarInfo;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int NOT_MOVE = 1;
    private static final int MOVE = 4;

    @ParameterizedTest
    @CsvSource(value = {"2, 0", "4, 1", "5, 1"})
    @DisplayName("랜덤의 값이 4 이상이면 1만큼 더 움직이고, 4 미만이면 움직이지 않는다.")
    void playOneRound(int randomNumber, int newPosition) {
        int round = 1;
        Car car = new Car("kyeou");
        assertRandomNumberInRangeTest(() -> {
            CarInfo carInfo = car.playOneRound(round);
            assertThat(carInfo.name()).isEqualTo("kyeou");
            assertThat(carInfo.currentPosition()).isEqualTo(newPosition);
            assertThat(carInfo.currentRound()).isEqualTo(round);
        }, randomNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3"})
    @DisplayName("랜덤의 값이 4 이상이면 1만큼 더 움직인다.")
    void playOneRound2(int position, int round) {
        Car car = new Car("aaa");
        for (int i = 0; i < round; i++) {
            assertRandomNumberInRangeTest(() -> {
                car.playOneRound(round);
            }, MOVE);
        }
        assertRandomNumberInRangeTest(() -> {
            CarInfo carInfo = car.playOneRound(round);
            assertThat(carInfo.currentPosition()).isEqualTo(position);
        }, NOT_MOVE);
    }
}