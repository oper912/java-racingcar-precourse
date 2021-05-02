package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidMoveCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveCountTest {

    @DisplayName("0 또는 음수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void check_move_count(int moveCount) {
        assertThatThrownBy(() -> MoveCount.from(moveCount))
                .isInstanceOf(InvalidMoveCountException.class)
                .hasMessage("유효하지않은 이동 횟수입니다.");
    }

    @DisplayName("남아있는 이동 횟수가 0보다 크면 이동이 가능하다")
    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,true"})
    void isMoveable(int count, boolean expected) {
        // given
        MoveCount moveCount = MoveCount.from(count);

        // when
        moveCount.minus();

        // then
        assertThat(moveCount.isMoveable()).isEqualTo(expected);
    }

    @DisplayName("이동 횟수를 소비하면 이동 회수가 줄어든다")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,1", "3,2"})
    void minus(int count, String expected) {
        // given
        MoveCount moveCount = MoveCount.from(count);

        // when
        moveCount.minus();

        // then
        assertThat(moveCount.toString()).isEqualTo(expected);
    }
}