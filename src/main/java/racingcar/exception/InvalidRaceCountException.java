package racingcar.exception;

public class InvalidRaceCountException extends RuntimeException {
    private static final String MESSAGE = "유효하지않은 이동 횟수입니다.";

    public InvalidRaceCountException() {
        super(MESSAGE);
    }
}
