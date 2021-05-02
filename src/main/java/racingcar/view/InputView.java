package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAMES_SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String carNames = scanner.nextLine();
        return Arrays.asList(carNames.split(CAR_NAMES_SEPARATOR));
    }
}
