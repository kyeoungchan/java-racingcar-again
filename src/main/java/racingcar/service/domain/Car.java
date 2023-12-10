package racingcar.service.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.consts.ValueConstants;
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

    public CarInfo playOneRound(int round) {
        if (ifMoved()) {
            position++;
        }
        return generateCarInfo(round);
    }

    private boolean ifMoved() {
        int randomNumber = Randoms.pickNumberInRange(
                ValueConstants.START_INCLUSIVE.getValue(),
                ValueConstants.END_INCLUSIVE.getValue()
        );
        return randomNumber >= ValueConstants.MOVE_STANDARD.getValue();
    }

    private CarInfo generateCarInfo(int round) {
        return new CarInfo(name, position, round);
    }

}
