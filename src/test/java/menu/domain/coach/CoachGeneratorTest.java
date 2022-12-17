package menu.domain.coach;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachGeneratorTest {

    @DisplayName("2명의 코치를 생성하면 코치 레파지토리에 2명의 코치 객체가 저장된다")
    @Test
    void makeCoaches() {
        List<String> coaches = List.of("기린", "하마");
        CoachGenerator.makeCoaches(coaches);
        assertThat(CoachRepository.getCoachRepositoryInstance().getCoaches().size()).isEqualTo(2);
    }
}