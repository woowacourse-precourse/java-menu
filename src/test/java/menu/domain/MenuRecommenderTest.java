package menu.domain;

import menu.util.RepeatValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRecommenderTest {

    private MenuRecommender menuRecommender;

    @BeforeEach
    private void setup() {
        menuRecommender = new MenuRecommender();
    }

    @DisplayName(value = "코치 등록중 오류시 코치 수 초기화 테스트")
    @Test
    void coachInitTest() {
        List<String> wrongInput = List.of("하나", "둘둘", "하나");
        List<String> input = List.of("하나", "둘둘", "세셋", "테스트");
        AtomicBoolean tryFlag = new AtomicBoolean(false);

        RepeatValidator.runUntilValidate(() -> {
            if (!tryFlag.get()) {
                tryFlag.set(true);
                menuRecommender.addCoaches(wrongInput);
            }
            menuRecommender.addCoaches(input);
        });
        assertThat(menuRecommender.getCoaches().size()).isEqualTo(input.size());
    }

}