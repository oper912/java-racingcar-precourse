package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_POSITION_MESSAGE = "%s : %s";
    private static final String POSITION_CHARACTER = "-";

    public void printResultMessage() {
        System.out.println(String.format("%n%s", RESULT_MESSAGE));
    }

    public void printRaceResult(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_POSITION_MESSAGE, car.getName(), positionToString(car)));
        }
        System.out.printf("%n");
    }

    private String positionToString(final Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_CHARACTER);
        }
        return builder.toString();
    }
}
