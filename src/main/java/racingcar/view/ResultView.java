package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_POSITION_MESSAGE_FORMAT = "%s : %s";
    private static final String POSITION_CHARACTER = "-";
    private static final String WINNERS_MESSAGE = "%s가 최종 우승 했습니다.";
    private static final String WINNER_NAME_SEPARATOR = ", ";

    public void printResultMessage() {
        System.out.println(String.format("%n%s", RESULT_MESSAGE));
    }

    public void printRaceResult(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_POSITION_MESSAGE_FORMAT, car.getName(), positionToString(car)));
        }
        System.out.print(System.lineSeparator());
    }

    private String positionToString(final Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_CHARACTER);
        }
        return builder.toString();
    }

    public void printWinners(final Winners winners) {
        List<String> winnerNames = winners.getWinnerNames();
        System.out.println(String.format(WINNERS_MESSAGE, String.join(WINNER_NAME_SEPARATOR, winnerNames)));
    }
}
