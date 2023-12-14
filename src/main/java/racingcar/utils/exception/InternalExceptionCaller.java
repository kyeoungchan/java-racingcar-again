package racingcar.utils.exception;

import racingcar.utils.consts.ExceptionMessage;

public class InternalExceptionCaller extends IllegalArgumentExceptionCaller {
    public static IllegalArgumentException call(String message) {
        String internalMessage = generateInternalMessage(message);
        return new IllegalArgumentException(generateExceptionMessage(internalMessage));
    }

    public static IllegalArgumentException call(String message, Throwable t) {
        String internalMessage = generateInternalMessage(message);
        return new IllegalArgumentException(generateExceptionMessage(internalMessage), t);
    }

    private static String generateInternalMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionMessage.INTERNAL_ERROR.getMessage());
        sb.append(message);
        return sb.toString();
    }
}
