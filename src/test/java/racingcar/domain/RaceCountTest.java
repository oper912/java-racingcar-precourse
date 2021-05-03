package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidRaceCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCountTest {

    @DisplayName("0 또는 음수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void check_move_count(int raceCount) {
        assertThatThrownBy(() -> RaceCount.from(raceCount))
                .isInstanceOf(InvalidRaceCountException.class)
                .hasMessage("유효하지않은 이동 횟수입니다.");
    }

    @DisplayName("남아있는 경주 횟수가 0보다 크면 경주가 가능하다")
    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,true"})
    void isMoveable(int count, boolean expected) {
        // given
        RaceCount raceCount = RaceCount.from(count);

        // when
        raceCount.race();

        // then
        assertThat(raceCount.isRaceable()).isEqualTo(expected);
    }

    @DisplayName("경주를 하면 경주 횟수가 줄어든다")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,1", "3,2"})
    void minus(int count, String expected) {
        // given
        RaceCount raceCount = RaceCount.from(count);

        // when
        raceCount.race();

        // then
        assertThat(raceCount.toString()).isEqualTo(expected);
    }
}