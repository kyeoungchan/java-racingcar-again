package racingcar.view;

import racingcar.utils.consts.Sentence;

public class OutputView {
    public void guidToInputCarNames() {
        System.out.println(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    public void guidToInputRound() {
        System.out.println(Sentence.INPUT_ROUND.getMessage());
    }
}
