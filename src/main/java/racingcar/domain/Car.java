package racingcar.domain;

import racingcar.strategy.MoveableStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    private Car(final Name name) {
        this.name = name;
        this.position = Position.init();
    }

    public static Car from(final String name) {
        return new Car(Name.from(name));
    }

    public void move(MoveableStrategy moveableStrategy) {
        if (moveableStrategy.moveable()) {
            position.move();
        }
    }

    public boolean isWinner(Position winnerPosition) {
        return position.equals(winnerPosition);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
