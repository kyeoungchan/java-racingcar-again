package racingcar.validator;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.vo.CarNames;

import static org.assertj.core.api.Assertions.assertThat;

class CarNamesTest {

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("중복된 자동차 이름이 있으면 중복을 제거하고 출력해준다.")
    void processDuplicatedCars(List<String> inputCarNames, List<String> processedCarNames) {
        CarNames carNameeVo = new CarNames(inputCarNames);
        assertThat(carNameeVo.carNames())
                .isEqualTo(processedCarNames);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.arguments(List.of("car1", "car2", "car1", "car3"), List.of("car11", "car2", "car12", "car3")),
                Arguments.arguments(List.of("car", "car", "car"), List.of("car1", "car2", "car3")),
                Arguments.arguments(List.of("car", "kar", "car", "kar"), List.of("car1", "kar2", "car3", "kar4"))
        );
    }
}