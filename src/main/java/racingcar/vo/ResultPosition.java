package racingcar.vo;

import java.util.LinkedHashMap;
import java.util.Map;

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

    public boolean isThisRound(int round) {
        return positionsPerRound.containsKey(round);
    }
}
