package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    @DisplayName("코치 이름 검증")
    public void validateName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Coach("안녕하세요");
        }).withMessageStartingWith("코치의 이름이 올바르지 않습니다.");

    }

    @Test
    @DisplayName("이미 등록된 메뉴를 다시 등록할 경우 예외처리한다.")
    public void throwExceptionForDuplicateMenu() {
        Coach hi = new Coach("포비");
        hi.addMenuCannotEat("안뇽");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            hi.addMenuCannotEat("안뇽");
        }).withMessageStartingWith("해당 코치가 못 먹는 메뉴로 이미 등록돼있습니다.");
    }

    @Test
    @DisplayName("코치는 메뉴를 추천할 수 있다.")
    public void recommendExcludeMenusNotToEat() {
        Coach coach = new Coach("헤헤");
        Set<String> notToEat = Set.of("우동", "스시", "뇨끼", "월남쌈", "마파두부", "고추잡채");
        coach.recommendMenu(Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5)), notToEat);

        assertThat(coach.getRecommendationForWeek()).doesNotContain(notToEat.toArray(new String[notToEat.size()]));
    }
}