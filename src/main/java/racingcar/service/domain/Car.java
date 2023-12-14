package racingcar.service.domain;

import racingcar.vo.CarInfo;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName();
        this.name = name;
        position = 0;
    }

    private void validateName() {

    }

    public CarInfo playOneRound(int round, boolean movingStatus) {
        if (movingStatus) {
            position++;
        }
        return generateCarInfo(round);
    }

    private CarInfo generateCarInfo(int round) {
        return new CarInfo(name, position, round);
    }

}
