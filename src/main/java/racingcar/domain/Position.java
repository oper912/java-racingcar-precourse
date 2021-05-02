package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final String POSITION_CHARACTER = "-";
    private static final int INIT_POSITION = 0;

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position init() {
        return new Position(INIT_POSITION);
    }

    public void progress() {
        this.position++;
    }

    public String positionToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_CHARACTER);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
