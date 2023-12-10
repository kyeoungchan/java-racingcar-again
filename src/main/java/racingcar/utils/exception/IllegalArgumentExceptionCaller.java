package racingcar.utils.exception;

import racingcar.utils.consts.ExceptionMessage;

public class IllegalArgumentExceptionCaller {
    public static IllegalArgumentException call(String message) {
        return new IllegalArgumentException(generateExceptionMessage(message));
    }

    public static IllegalArgumentException call(String message, Throwable t) {
        return new IllegalArgumentException(generateExceptionMessage(message), t);
    }
    private static String generateExceptionMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionMessage.PREFIX.getMessage());
        sb.append(message);
        return sb.toString();
    }
}
