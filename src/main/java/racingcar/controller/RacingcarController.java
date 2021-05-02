package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.strategy.MoveableStrategy;
import racingcar.strategy.RandomMoveableStrategy;
import racingcar.view.InputView;

import java.util.List;

public class RacingcarController {
    private final InputView inputView;
    private final MoveableStrategy moveableStrategy;

    public RacingcarController() {
        this.inputView = new InputView();
        this.moveableStrategy = new RandomMoveableStrategy();
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        int moveCount = inputView.inputMoveCount();
        RacingGame racingGame = RacingGame.init(carNames, moveCount);

        while (racingGame.isRaceable()) {
            racingGame.race(moveableStrategy);
        }
    }
}
