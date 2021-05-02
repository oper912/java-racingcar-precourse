package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null 또는 공백을 전달하면 true를 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String value) {
        assertThat(StringUtils.isBlank(value)).isTrue();
    }
}