package menu.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MenuDtoTest {

    @Test
    void getMenus_Test() {
        assertThat(new MenuDto("김치찌개,삼겹살").getMenus())
                .containsAll(List.of("김치찌개", "삼겹살"));
    }

}