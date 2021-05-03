package racingcar.domain;

import racingcar.strategy.MoveableStrategy;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceCount raceCount;

    private RacingGame(final Cars cars, final RaceCount raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public static RacingGame init(final List<String> carNames, final int raceCount) {
        return new RacingGame(Cars.from(carNames), RaceCount.from(raceCount));
    }

    public boolean isRaceable() {
        return raceCount.isRaceable();
    }

    public void race(MoveableStrategy moveableStrategy) {
        cars.move(moveableStrategy);
        raceCount.race();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
