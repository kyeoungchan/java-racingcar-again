package racingcar.vo;

import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.consts.ValueConstants;
import racingcar.utils.exception.InputExceptionCaller;

public record Round(int finalRound) {
    public Round {
        validate(finalRound);
    }

    private void validate(int finalRound) {
        validateNaturalNumber(finalRound);
        validateMaximumRound(finalRound);
    }

    private void validateNaturalNumber(int finalRound) {
        if (finalRound < ValueConstants.SMALLEST_NATURAL_NUMBER.getValue()) {
            throw InputExceptionCaller.call(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private void validateMaximumRound(int finalRound) {
        if (finalRound > ValueConstants.MAXIMUM_ROUND.getValue()) {
            throw InputExceptionCaller.call(ExceptionMessage.EXCEEDS_MAXIMUM_ROUND.getMessage());
        }
    }
}
