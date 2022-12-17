package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CouchTest {

    @DisplayName("못먹는 음식이 중복될 경우 예외 처리 테스트")
    @Test
    void duplicatedCouchNameTest() {
        Couch couch = Couch.of("구구");

        assertThatThrownBy(() -> {
            couch.setUneatableMenus(List.of("떡볶이", "떡볶이"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}