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

    @DisplayName("자동차가 이동하면 위치가 증가한다")
    @Test
    void move() {
        // given
        Car car = Car.from("snow");

        // when
        car.move(new TestMoveableStrategy());

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("우승 위치와 같으면 우승자로 판단한다")
    @Test
    void isWinner() {
        // given
        Car car = Car.from("snow");
        Position winnerPosition = Position.from(1);

        // when
        car.move(new TestMoveableStrategy());

        // then
        assertThat(car.isWinner(winnerPosition)).isTrue();
    }
}
