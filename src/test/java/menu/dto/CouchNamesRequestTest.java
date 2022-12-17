package menu.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CouchNamesRequestTest {

    @ParameterizedTest
    @DisplayName("코치들이 정상적으로 생성되어야 한다.")
    @ValueSource(strings = {"하하,하이", "하하하,하하하하", "하하,하하하,", "하하,하하하,하하하하,하이,하이하이"})
    void createCouchCouldBeSuccess(String input) {
        // expect
        assertThat(CouchNamesRequest.of(input))
                .isNotNull();
    }

    @Test
    @DisplayName("코치의 이름은 2글자에서 4글자 사이어야 한다.")
    void couchNameByOverThen2AndLessThen4() {
        // expect
        assertThatThrownBy(() -> CouchNamesRequest.of("하하,하"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("코치의 인원 수는 2명에서 5명 사이어야 한다.")
    @ValueSource(strings = {"하하,하하,하하,하하,하하,하하","하하"})
    void couchNumberByOverThen2AndLessThen5(String input) {
        // expect
        assertThatThrownBy(() -> CouchNamesRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("코치의 이름이 중복되어선 안된다.")
    void couchNameByDuplicate() {
        // expect
        assertThatThrownBy(() -> CouchNamesRequest.of("하하,하하"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}