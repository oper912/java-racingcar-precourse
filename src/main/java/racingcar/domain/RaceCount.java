package racingcar.domain;

import racingcar.exception.InvalidRaceCountException;

import java.util.Objects;

public class RaceCount {
    private static final int END_COUNT = 0;

    private int count;

    private RaceCount(final int count) {
        this.count = count;
    }

    public static RaceCount from(final int count) {
        validateCount(count);
        return new RaceCount(count);
    }

    private static void validateCount(final int count) {
        if (END_COUNT >= count) {
            throw new InvalidRaceCountException();
        }
    }

    public boolean isRaceable() {
        return END_COUNT < count;
    }

    public void race() {
        this.count--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCount raceCount = (RaceCount) o;
        return count == raceCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
