package racingcar.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.exception.IllegalArgumentExceptionCaller;
import racingcar.utils.exception.InternalExceptionCaller;

public class SingleRoundPosition {
    private final Map<String, Integer> carPositions = new LinkedHashMap<>();

    public void writeNewCarPosition(String carName, int position) {
        carPositions.put(carName, position);
    }

    public List<String> getCarNames() {
        return new ArrayList<>(carPositions.keySet());
    }

    public int getPosition(String carName) {
        if (!carPositions.containsKey(carName)) {
            throw InternalExceptionCaller.call(String.format(ExceptionMessage.NOT_EXISTING_ROUND.getMessage(), carName));
        }
        return carPositions.get(carName);
    }

}
