package racingcar.utils.exception;

import racingcar.utils.consts.ExceptionMessage;

public class InputExceptionCaller extends IllegalArgumentExceptionCaller {
    public static IllegalArgumentException call(String message) {
        String inputMessage = generateInputMessage(message);
        return new IllegalArgumentException(generateExceptionMessage(inputMessage));
    }

    public static IllegalArgumentException call(String message, Throwable t) {
        String inputMessage = generateInputMessage(message);
        return new IllegalArgumentException(generateExceptionMessage(inputMessage), t);
    }

    private static String generateInputMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionMessage.INPUT_ERROR.getMessage());
        sb.append(message);
        return sb.toString();
    }
}
