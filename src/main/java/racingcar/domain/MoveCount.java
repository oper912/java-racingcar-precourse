package racingcar.domain;

import racingcar.exception.InvalidMoveCountException;

import java.util.Objects;

public class MoveCount {
    private static final int END_COUNT = 0;

    private int count;

    private MoveCount(final int count) {
        this.count = count;
    }

    public static MoveCount from(final int count) {
        validateCount(count);
        return new MoveCount(count);
    }

    private static void validateCount(final int count) {
        if (END_COUNT >= count) {
            throw new InvalidMoveCountException();
        }
    }

    public boolean isMoveable() {
        return END_COUNT < count;
    }

    public void minus() {
        this.count--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCount moveCount = (MoveCount) o;
        return count == moveCount.count;
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
