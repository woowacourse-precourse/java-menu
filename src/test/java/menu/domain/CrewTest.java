package menu.domain;

import static menu.factory.CrewFactory.createCrew;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrewTest {
    @Test
    @DisplayName("코치 음식 추가시에 이미 있는 음식인지 테스트")
    public void addFoodTest() {
        // given
        Crew crew = createCrew("포비");

        // when
        crew.addFood("초밥");

        // then
        assertThat(crew.isAlreadyBeenFood("초밥")).isEqualTo(true);
    }
}
