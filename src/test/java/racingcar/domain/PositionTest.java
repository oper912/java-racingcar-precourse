package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("초기 위치는 0으로 생성된다")
    @Test
    void init() {
        // given
        int expectedPosition = 0;

        // when
        Position position = Position.init();

        // then
        assertThat(position.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("이동하면 위치가 증가한다")
    @Test
    void move() {
        // given
        Position position = Position.init();

        // when
        position.move();

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
