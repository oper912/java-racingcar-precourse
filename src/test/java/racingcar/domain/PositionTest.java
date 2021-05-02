package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("초기 position은 0으로 생성된다")
    @Test
    void init() {
        // given
        Position position = Position.init();

        // when
        String positionString = position.positionToString();

        // then
        assertThat(positionString).isEqualTo("");
    }

    @DisplayName("전진하면 position이 증가한다")
    @Test
    void progress() {
        // given
        Position position = Position.init();

        // when
        position.progress();

        // then
        assertThat(position.positionToString()).isEqualTo("-");
    }
}
