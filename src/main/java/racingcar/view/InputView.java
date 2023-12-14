package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;
import racingcar.vo.CarNames;
import racingcar.vo.Round;

public class InputView {
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public InputView(OutputView outputView, InputValidator inputValidator) {
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public CarNames inputCarNames() {
        outputView.guidToInputCarNames();
        String carNamesData = Console.readLine();
        return new CarNames(inputValidator.parseToStrings(carNamesData));
    }

    public Round inputRound() {
        outputView.guidToInputRound();
        String roundData = Console.readLine();
        return new Round(inputValidator.parseToInt(roundData));
    }
}
