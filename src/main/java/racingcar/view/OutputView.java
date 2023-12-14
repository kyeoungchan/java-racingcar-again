package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.utils.consts.ExceptionMessage;
import racingcar.utils.consts.Sentence;
import racingcar.utils.consts.ValueConstants;
import racingcar.vo.ResultPosition;
import racingcar.vo.SingleRoundPosition;

public class OutputView {
    public void guidToInputCarNames() {
        System.out.println(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    public void guidToInputRound() {
        System.out.println(Sentence.INPUT_ROUND.getMessage());
    }

    public void printAllPositions(ResultPosition resultPosition, int finalRound) {
        printLineSeparator();
        int endExclusive = finalRound + 1;
        int startInclusive = 1;
        IntStream.range(startInclusive, endExclusive)
                .forEach(round -> {
                    SingleRoundPosition positionsByRound = resultPosition.getPositionsByRound(round);
                    positionsByRound.getCarNames()
                            .forEach(carName -> printCarWithPosition(carName, positionsByRound.getPosition(carName)));
                    printLineSeparator();
                });
    }

    private void printCarWithPosition(String carName, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName);
        sb.append(Sentence.SEPARATOR.getMessage());
        sb.append(positionToString(position));
        System.out.println(sb);
    }

    private String positionToString(int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(Sentence.POSITION_EXPRESSION.getMessage().repeat(Math.max(0, position)));
        return sb.toString();
    }

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(Sentence.WINNERS_GUIDE.getMessage());
        sb.append(Sentence.SEPARATOR.getMessage());
        winners.forEach(winner -> {
            sb.append(winner);
            sb.append(Sentence.SEPARATOR_TO_LIST.getMessage());
        });
        sb.delete(sb.length() - ValueConstants.DIGITS_ADDED_COMMA.getValue(), sb.length());
        System.out.println(sb);
    }

    private void printLineSeparator() {
        System.out.print(System.lineSeparator());
    }

    public void printErrorMessage(String message) {
        System.out.println((generateMessage(message, ExceptionMessage.RETRY.getMessage())));
    }

    private String generateMessage(String message, String postfix) {
        return message + postfix;
    }
}
