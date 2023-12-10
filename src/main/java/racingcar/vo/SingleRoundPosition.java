package racingcar.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.utils.exception.IllegalArgumentExceptionCaller;

public class SingleRoundPosition {
    private final Map<String, Integer> carPositions = new LinkedHashMap<>();

    public void writeNewCarPosition(String carName, int position) {
        carPositions.put(carName, position);
    }

    public int getPosition(String carName) {
        if (!carPositions.containsKey(carName)) {
            throw IllegalArgumentExceptionCaller.call(String.format("There's no car %s", carName));
        }
        return carPositions.get(carName);
    }

}
