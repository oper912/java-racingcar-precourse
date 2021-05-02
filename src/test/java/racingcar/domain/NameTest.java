package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.CarNameValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("객체 생성 및 동등성 확인")
    @Test
    void equals() {
        // given
        String inputName = "snow";
        Name name = Name.from(inputName);

        // when
        Name expectedName = Name.from(inputName);

        // then
        assertThat(name).isEqualTo(expectedName);
    }

    @DisplayName("이름에 null 또는 공백 입력시 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void check_blank_name(String name) {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(CarNameValidationException.class)
                .hasMessage("이름은 null 또는 공백이 될 수 없습니다.");
    }

    @DisplayName("이름을 5자 초과 입력하면 예외가 발생한다")
    @Test
    void check_max_length_name() {
        // given
        String inputName = "soonho";

        // when

        // then
        assertThatThrownBy(() -> Name.from(inputName))
                .isInstanceOf(CarNameValidationException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
