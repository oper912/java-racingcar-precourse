package racingcar.exception;

public class CarNameValidationException extends RuntimeException {

    public CarNameValidationException(final String message) {
        super(message);
    }
}
