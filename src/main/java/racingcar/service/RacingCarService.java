package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.FinalResult;
import racingcar.service.domain.Car;
import racingcar.service.domain.RandomEngine;
import racingcar.service.domain.Record;
import racingcar.service.domain.WinnersCalculator;
import racingcar.vo.CarNames;
import racingcar.vo.ResultPosition;
import racingcar.vo.Round;

public class RacingCarService {
    private final RandomEngine randomEngine;
    private Record record;
    private final WinnersCalculator winnersCalculator;

    public RacingCarService(RandomEngine randomEngine, WinnersCalculator winnersCalculator) {
        this.randomEngine = randomEngine;
        this.winnersCalculator = winnersCalculator;
    }

    public FinalResult race(CarNames carNames, Round round) {
        int finalRound = round.finalRound();
        record = new Record(finalRound);
        List<Car> cars = getCars(carNames);
        ResultPosition resultPosition = generateResultPosition(cars);
        List<String> winners = winnersCalculator.calculateWinners(resultPosition, finalRound);
        return new FinalResult(resultPosition, winners);
    }

    private ResultPosition generateResultPosition(List<Car> cars) {
        int currentRound = 0;
        while (!record.isFinalRound()) {
            currentRound++;
            raceSingleRound(cars, currentRound);
        }
        return record.getAllPositions();
    }

    private void raceSingleRound(List<Car> cars, int currentRound) {
        cars.stream()
                .map(car -> car.playOneRound(currentRound, randomEngine.ifMove()))
                .forEach(carInfo -> record.writePosition(carInfo));
    }

    private List<Car> getCars(CarNames carNames) {
        return carNames.carNames()
                .stream()
                .map(Car::new)
                .toList();
    }
}
