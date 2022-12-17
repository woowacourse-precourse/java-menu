package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void 매개값이_1과_5_사이의_숫자가_아니면_예외를_발생시킨다(int number) {
        assertThatThrownBy(() -> Category.findFoodBy(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("카테고리 선정을 하려면 1에서 5 사이의 숫자를 입력해주세요.");
    }

    @Test
    void 숫자_1을_입력하면_일식_메뉴들을_반환한다() {
        assertThat(Category.findFoodBy(1)).isEqualTo(List.of(
                "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
        ));
    }

    @Test
    void 숫자_2를_입력하면_한식_메뉴들을_반환한다() {
        assertThat(Category.findFoodBy(2)).isEqualTo(List.of(
                "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
        ));
    }

    @Test
    void 숫자_3을_입력하면_중식_메뉴들을_반환한다() {
        assertThat(Category.findFoodBy(3)).isEqualTo(List.of(
                "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
        ));
    }

    @Test
    void 숫자_4를_입력하면_아시안_메뉴들을_반환한다() {
        assertThat(Category.findFoodBy(4)).isEqualTo(List.of(
                "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
        ));
    }

    @Test
    void 숫자_5를_입력하면_양식_메뉴들을_반환한다() {
        assertThat(Category.findFoodBy(5)).isEqualTo(List.of(
                "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
        ));
    }
}