package menu.service.dto;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.Test;

class CoachNameDtoTest {
    @Test
    void getNames_Test() {
        assertThat(new CoachNameDto("김치찌개,삼겹살").getNames())
                .containsAll(List.of("김치찌개", "삼겹살"));
    }
}