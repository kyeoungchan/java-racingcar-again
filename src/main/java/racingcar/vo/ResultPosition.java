package racingcar.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.exception.IllegalArgumentExceptionCaller;

public class ResultPosition {
    private final Map<Integer, SingleRoundPosition> positionsPerRound = new LinkedHashMap<>();

    public void addNewPosition(CarInfo carInfo) {
        int round = carInfo.currentRound();

        SingleRoundPosition singleRound =
                positionsPerRound.getOrDefault(round, new SingleRoundPosition());
        singleRound.writeNewCarPosition(carInfo.name(), carInfo.currentPosition());
        appendNewRound(round, singleRound);
    }

    private void appendNewRound(int round, SingleRoundPosition singleRound) {
        if (!positionsPerRound.containsKey(round)) {
            positionsPerRound.put(round, singleRound);
        }
    }

    public SingleRoundPosition getPositionsByRound(int round) {
        if (!positionsPerRound.containsKey(round)) {
            String message = String.format(ExceptionMessage.NOT_EXISTING_ROUND.getMessage(), round);
            throw IllegalArgumentExceptionCaller.call(message);
        }
        return positionsPerRound.get(round);
    }

    public boolean isThisRound(int round) {
        return positionsPerRound.containsKey(round) && !positionsPerRound.containsKey(round + 1);
    }
}
