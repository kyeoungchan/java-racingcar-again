package racingcar.service.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.vo.CarInfo;
import racingcar.vo.ResultPosition;

class WinnersCalculatorTest {
    private final WinnersCalculator winnersCalculator = new WinnersCalculator();

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("거리가 가장 많은 자동차들의 목록을 출력한다.")
    void calculateWinners(ResultPosition resultPosition, int round, List<String> winners) {
        List<String> calculatedWinners = winnersCalculator.calculateWinners(resultPosition, round);
        Assertions.assertThat(calculatedWinners).isEqualTo(winners);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.arguments(generateResultPosition(
                        List.of("pobi", "kyeou", "hihi"),
                        List.of(1, 2, 3),
                        1
                ), 1, List.of("hihi")),
                Arguments.arguments(generateResultPosition(
                        List.of("pobi", "kyeou", "hihi"),
                        List.of(1, 3, 3),
                        1
                ), 1, List.of("kyeou", "hihi")),
                Arguments.arguments(generateResultPosition(
                        List.of("pobi", "kyeou", "hihi"),
                        List.of(3, 3, 3),
                        1
                ), 1, List.of("pobi", "kyeou", "hihi"))
        );
    }

    private static ResultPosition generateResultPosition(List<String> carNames, List<Integer> positions, int round) {
        ResultPosition resultPosition = new ResultPosition();
        if (carNames.size() == positions.size()) {
            for (int i = 0; i < carNames.size(); i++) {
                resultPosition.addNewPosition(new CarInfo(carNames.get(i), positions.get(i), round));
            }
        }
        return resultPosition;
    }
}