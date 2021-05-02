package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.strategy.TestMoveableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    @DisplayName("자동차 이름 수만큼 자동차가 생성된다")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:2", "pobi,crong,honux:3", "pobi,crong,honux,snow:4"}, delimiter = ':')
    void check_size(String carNames, int expectedSize) {
        // given
        Cars cars = Cars.from(Arrays.asList(carNames.split(",")));

        // when
        int carsSize = cars.getCars().size();

        // then
        assertThat(carsSize).isEqualTo(expectedSize);
    }

    @DisplayName("이동하면 모든 자동차들의 position이 증가한다")
    @Test
    void move() {
        // given
        List<String> carNames = Arrays.asList("pobi,crong,honux".split(","));
        Cars cars = Cars.from(carNames);

        // when
        cars.move(new TestMoveableStrategy());
        List<Car> carList = cars.getCars();

        // then
        assertAll(
                () -> assertThat(carList.get(0).getPosition()).isEqualTo(1),
                () -> assertThat(carList.get(1).getPosition()).isEqualTo(1),
                () -> assertThat(carList.get(2).getPosition()).isEqualTo(1)
        );
    }

    @DisplayName("unmodifiableList를 수정하려고하면 예외가 발생한다")
    @Test
    void unmodifiableList_change_exception() {
        // given
        List<String> carNames = Arrays.asList("pobi,crong,honux".split(","));
        Cars cars = Cars.from(carNames);

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThatThrownBy(() -> {
            carList.add(Car.from("test"));
        }).isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> {
            carList.remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
