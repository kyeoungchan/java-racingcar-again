package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.FinalResult;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.CarNames;
import racingcar.vo.ResultPosition;
import racingcar.vo.Round;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        CarNames carNames = validatingTemplate(this::getCarNames);
        Round round = validatingTemplate(this::getRound);
        FinalResult raceResult = racingCarService.race(carNames, round);
        processResult(raceResult, round.finalRound());
    }

    private CarNames getCarNames() {
        return inputView.inputCarNames();
    }

    private Round getRound() {
        return inputView.inputRound();
    }

    private void processResult(FinalResult raceResult, int finalRound) {
        processAllPositions(raceResult.resultPosition(), finalRound);
        processWinners(raceResult.winners());
    }

    private void processAllPositions(ResultPosition resultPosition, int finalRound) {
        outputView.printAllPositions(resultPosition, finalRound);
    }

    private void processWinners(List<String> winners) {
        outputView.printWinners(winners);
    }

    private <T> T validatingTemplate(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
