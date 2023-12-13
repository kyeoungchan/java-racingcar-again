package racingcar.service.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.exception.IllegalArgumentExceptionCaller;
import racingcar.vo.ResultPosition;
import racingcar.vo.SingleRoundPosition;

public class WinnersCalculator {
    public List<String> calculateWinners(ResultPosition resultPosition, int round) {
        SingleRoundPosition positionsByRound = resultPosition.getPositionsByRound(round);
        List<String> carNames = positionsByRound.getCarNames();
        int maxPosition = calculateMaxPosition(positionsByRound, carNames);
        return carNames.stream()
                .filter(carName -> positionsByRound.getPosition(carName) == maxPosition)
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition(SingleRoundPosition positionsByRound, List<String> carNames) {
        return carNames.stream()
                .map(positionsByRound::getPosition)
                .mapToInt(x -> x)
                .max()
                .orElseThrow(() ->
                        IllegalArgumentExceptionCaller.call(ExceptionMessage.ILLEGAL_ROUND_TO_CALCULATE.getMessage())
                );
    }
}
