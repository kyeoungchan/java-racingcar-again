package racingcar.service.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.consts.ValueConstants;

public class RandomEngine {
    public boolean ifMove() {
        return generateEngine() >= ValueConstants.MOVE_STANDARD.getValue();
    }

    private int generateEngine() {
        return Randoms.pickNumberInRange(
                ValueConstants.START_INCLUSIVE.getValue(),
                ValueConstants.END_INCLUSIVE.getValue()
        );
    }
}
