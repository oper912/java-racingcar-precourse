package racingcar.domain;

import racingcar.strategy.MoveableStrategy;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MoveCount moveCount;

    private RacingGame(final Cars cars, final MoveCount moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public static RacingGame init(final List<String> carNames, final int moveCount) {
        return new RacingGame(Cars.from(carNames), MoveCount.from(moveCount));
    }

    public boolean isRaceable() {
        return moveCount.isMoveable();
    }

    public void race(MoveableStrategy moveableStrategy) {
        cars.move(moveableStrategy);
        moveCount.minus();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
