package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.strategy.MoveableStrategy;
import racingcar.strategy.RandomMoveableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final ResultView resultView;
    private final MoveableStrategy moveableStrategy;

    public RacingCarController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.moveableStrategy = new RandomMoveableStrategy();
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        int raceCount = inputView.inputRaceCount();
        RacingGame racingGame = RacingGame.init(carNames, raceCount);

        raceCars(racingGame);
        assignWinners(racingGame.getCars());
    }

    private void raceCars(final RacingGame racingGame) {
        resultView.printResultMessage();
        while (racingGame.isRaceable()) {
            racingGame.race(moveableStrategy);
            resultView.printRaceResult(racingGame.getCars());
        }
    }

    private void assignWinners(final List<Car> cars) {
        Winners winners = Winners.newInstance();
        winners.assignWinners(cars);
        resultView.printWinners(winners);
    }
}
