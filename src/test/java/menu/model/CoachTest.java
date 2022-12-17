package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {
    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요", "오이이이이잉", "", "11111111"})
    @DisplayName("코치 이름이 올바르지 않은 경우 예외처리한다.")
    public void validateName(String nameInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Coach(nameInput);
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

    @Test
    @DisplayName("코치 멤버 테스트")
    public void testMember() {
        Coach coach = new Coach("헤헤");
        for(int i = 0; i < 5; i++) {
            coach.recommendMenu(Category.KOREAN, Set.of());
        }
        String result = Stream.of(List.of(coach.getName()), coach.getRecommendationForWeek()).flatMap(
                Collection::stream).collect(
                Collectors.joining(" | "));
        System.out.println(result);
    }
}