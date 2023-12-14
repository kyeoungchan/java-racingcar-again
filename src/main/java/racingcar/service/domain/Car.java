package racingcar.service.domain;

import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.consts.ValueConstants;
import racingcar.utils.exception.InputExceptionCaller;
import racingcar.vo.CarInfo;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name, ValueConstants.NAME_SIZE_LIMIT.getValue());
        this.name = name;
        position = 0;
    }

    private void validateName(String data, int length) {
        if (data.length() > length) {
            throw InputExceptionCaller.call(ExceptionMessage.TOO_LONG_NAME.getMessage());
        }
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
