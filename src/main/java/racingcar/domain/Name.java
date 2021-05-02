package racingcar.domain;

import racingcar.exception.CarNameValidationException;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class Name {
    private static final String NULL_OR_BLANK_MESSAGE = "이름은 null 또는 공백이 될 수 없습니다.";
    private static final String OUT_OF_BOUND_LENGTH_MESSAGE = "이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        validateName(name);
        return new Name(name);
    }

    private static void validateName(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new CarNameValidationException(NULL_OR_BLANK_MESSAGE);
        }
        if (MAX_LENGTH < name.length()) {
            throw new CarNameValidationException(OUT_OF_BOUND_LENGTH_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
