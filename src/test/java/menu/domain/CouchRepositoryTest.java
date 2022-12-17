package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CouchRepositoryTest {

    @DisplayName("코치 이름이 중복될 경우 예외 처리 테스트")
    @Test
    void duplicatedCouchNameTest() {
        CouchRepository.addCouch(Couch.of("구구"));

        assertThatThrownBy(() -> {
            CouchRepository.addCouch(Couch.of("구구"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}