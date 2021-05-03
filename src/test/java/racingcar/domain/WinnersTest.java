package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.TestMoveableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnersTest {

    @DisplayName("우승자를 배정하면 우승자 이름 목록을 가져올 수 있다")
    @Test
    void getWinnerNames() {
        // given
        Winners winners = Winners.newInstance();
        Cars cars = Cars.from(Arrays.asList("pobi", "snow", "kwon"));
        cars.move(new TestMoveableStrategy());

        // when
        winners.assignWinners(cars.getCars());

        // then
        assertAll(
                () -> assertThat(winners.getWinnerNames().get(0)).isEqualTo("pobi"),
                () -> assertThat(winners.getWinnerNames().get(1)).isEqualTo("snow"),
                () -> assertThat(winners.getWinnerNames().get(2)).isEqualTo("kwon")
        );
    }
}