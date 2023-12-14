package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.consts.PatternRegex;
import racingcar.utils.exception.InputExceptionCaller;

public class InputValidator {

    public List<String> parseToStrings(String carNamesData) {
        carNamesData = carNamesData.trim();
        validateIfEndByComma(carNamesData);
        return Arrays.stream(carNamesData.split(PatternRegex.SPLITTER.getValue()))
                .map(String::trim)
                .peek(this::validateBlank)
                .collect(Collectors.toList());
    }

    private void validateIfEndByComma(String carNamesData) {
        Pattern p = Pattern.compile(PatternRegex.END_BY_COMMA.getValue());
        Matcher m = p.matcher(carNamesData);
        if (m.matches()) {
            throw InputExceptionCaller.call(ExceptionMessage.INPUT_THINGS_AFTER_COMMA.getMessage());
        }
    }

    public int parseToInt(String roundData) {
        validateBlank(roundData);
        validateOnlyNumber(roundData);
        return Integer.parseInt(roundData);
    }

    private void validateBlank(String data) {
        if (data == null || data.length() == 0) {
            throw InputExceptionCaller.call(ExceptionMessage.BLANK.getMessage());
        }
    }

    private void validateOnlyNumber(String roundData) {
        Pattern p = Pattern.compile(PatternRegex.NUMBER_LEAST_ONE_DIGIT.getValue());
        Matcher m = p.matcher(roundData);
        if (!m.matches()) {
            throw InputExceptionCaller.call(ExceptionMessage.INPUT_ONLY_NUMBER.getMessage());
        }
    }
}
