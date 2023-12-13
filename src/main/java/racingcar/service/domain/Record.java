package racingcar.service.domain;

import racingcar.vo.CarInfo;
import racingcar.vo.ResultPosition;

public class Record {
    private final ResultPosition positions;
    private final int finalRound;

    public Record(int finalRound) {
        this.finalRound = finalRound;
        positions = new ResultPosition();
    }

    public void writePosition(CarInfo carInfo) {
        positions.addNewPosition(carInfo);
    }

    public ResultPosition getAllPositions() {
        return positions;
    }

    public boolean isFinalRound() {
        return positions.isThisRound(finalRound);
    }
}
