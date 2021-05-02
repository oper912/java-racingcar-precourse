package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {
    private final InputView inputView;

    public RacingcarController() {
        this.inputView = new InputView();
    }

    public void run() {
        inputView.inputCarNames();
    }
}
