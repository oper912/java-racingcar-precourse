package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;

    private Winners() {
        this.winners = new ArrayList<>();
    }

    public static Winners newInstance() {
        return new Winners();
    }

    public void assignWinners(final List<Car> cars) {
        Position winnerPosition = getWinnerPosition(cars);
        for (Car car : cars) {
            addWinners(car, winnerPosition);
        }
    }

    private void addWinners(final Car car, final Position winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            this.winners.add(car);
        }
    }

    private Position getWinnerPosition(final List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return Position.from(winnerPosition);
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
