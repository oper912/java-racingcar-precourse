package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameValidationException;
import racingcar.strategy.TestMoveableStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("유효하지않은 이름을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "soonho"})
    void invalid_name_exception(String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(CarNameValidationException.class);
    }

    @DisplayName("자동차가 이동하면 position이 증가한다")
    @Test
    void move() {
        // given
        Car car = Car.from("snow");

        // when
        car.move(new TestMoveableStrategy());

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
