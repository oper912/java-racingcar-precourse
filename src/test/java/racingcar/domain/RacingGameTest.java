package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.TestMoveableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @DisplayName("정상적으로 게임을 생성하면 경주가 가능하다")
    @Test
    void isRaceable() {
        // given
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        int raceCount = 1;

        // when
        RacingGame racingGame = RacingGame.init(carNames, raceCount);

        // then
        assertThat(racingGame.isRaceable()).isTrue();
    }

    @DisplayName("경주하면 자동차들의 위치가 증가한다")
    @Test
    void race() {
        // given
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        RacingGame racingGame = RacingGame.init(carNames, 1);

        // when
        racingGame.race(new TestMoveableStrategy());
        List<Car> carList = racingGame.getCars();

        // then
        assertAll(
                () -> assertThat(carList.get(0).getPosition()).isEqualTo(1),
                () -> assertThat(carList.get(1).getPosition()).isEqualTo(1),
                () -> assertThat(carList.get(2).getPosition()).isEqualTo(1)
        );
    }
}
