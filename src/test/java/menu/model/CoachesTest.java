package menu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoachesTest {
    Coaches coaches = new Coaches();

    @BeforeEach
    void initCoaches() {
        List<String> names = Arrays.asList("JJ", "pobi", "test");
        for (String name : names) {
            coaches.addCoach(new Coach(name));
        }
    }

    @DisplayName("코치 객체 가져오기 테스트")
    @Test
    void getCoaches() {
        List<Coach> coachNames = coaches.getCoaches();
        List<String> expectResult = Arrays.asList("JJ", "pobi", "test");

        for (int i = 0; i < coachNames.size(); i++) {
            assertThat(coachNames.get(i).getName()).isEqualTo(expectResult.get(i));
        }
    }
}
