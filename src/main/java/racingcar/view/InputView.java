package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public InputView(OutputView outputView, InputValidator inputValidator) {
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    List<String> inputCarNames() {
        outputView.guidToInputCarNames();
        String carNamesData = Console.readLine();
        return inputValidator.parseToStrings(carNamesData);
    }
}
