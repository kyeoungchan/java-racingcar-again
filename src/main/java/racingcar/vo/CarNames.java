package racingcar.vo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import racingcar.utils.consts.ValueConstants;

public record CarNames(List<String> carNames) {

    public CarNames(List<String> carNames) {
        this.carNames = processDuplicatedCars(carNames);
    }

    private List<String> processDuplicatedCars(List<String> carNames) {
        if (nothingDuplicated(carNames)) {
            return carNames;
        }

        Map<String, List<Integer>> carNameIndexes = new HashMap<>();
        generateCarNameIndexes(carNames, carNameIndexes);
        return getNewCarNames(carNames, carNameIndexes);
    }

    private List<String> getNewCarNames(List<String> carNames, Map<String, List<Integer>> carNameIndexes) {
        AtomicInteger postfix = new AtomicInteger(ValueConstants.START_INCLUSIVE.getValue());
        return carNames.stream().map(carName -> {
                    if (carNameIndexes.get(carName).size() <= 1) {
                        return carName;
                    }
                    return generateNewCarName(postfix.getAndIncrement(), carName);
                })
                .collect(Collectors.toList());
    }

    private void generateCarNameIndexes(List<String> carNames, Map<String, List<Integer>> carNameIndexes) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            if (!carNameIndexes.containsKey(carName)) {
                carNameIndexes.put(carName, new ArrayList<>());
            }
            carNameIndexes.get(carName).add(i);
        }
    }

    private String generateNewCarName(int postfix, String originalCarName) {
        return originalCarName + (postfix + 1);
    }

    private boolean nothingDuplicated(List<String> carNames) {
        return carNames.size() == new HashSet<>(carNames).size();
    }
}
