package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlacklistTest {

    @DisplayName("블랙리스트에 등록한 메뉴가 있으면 True를 반환한다.")
    @Test
    void existTest() {
        Blacklist blacklist = new Blacklist(List.of(new Menu("탕수육")));

        assertThat(blacklist.isExist(new Menu("탕수육"))).isTrue();
    }

}