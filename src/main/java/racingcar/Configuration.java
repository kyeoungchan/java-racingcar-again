package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.domain.RandomEngine;
import racingcar.service.domain.WinnersCalculator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Configuration {
    public static RacingCarController getRacingCarController() {
        OutputView outputView = getOutputView();
        return new RacingCarController(getInputView(outputView), outputView, getRacingCarService());
    }

    private static RacingCarService getRacingCarService() {
        return new RacingCarService(getRandomEngine(), getWinnersCalculator());
    }

    private static WinnersCalculator getWinnersCalculator() {
        return new WinnersCalculator();
    }

    private static RandomEngine getRandomEngine() {
        return new RandomEngine();
    }

    private static InputView getInputView(OutputView outputView) {
        return new InputView(outputView, getInputValidator());
    }

    private static InputValidator getInputValidator() {
        return new InputValidator();
    }

    private static OutputView getOutputView() {
        return new OutputView();
    }
}
