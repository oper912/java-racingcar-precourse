package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("초기 position은 0으로 생성된다")
    @Test
    void init() {
        // given
        int expectedPosition = 0;

        // when
        Position position = Position.init();

        // then
        assertThat(position.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("이동하면 position이 증가한다")
    @Test
    void progress() {
        // given
        Position position = Position.init();

        // when
        position.progress();

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
