package menu.domain;

import menu.utils.ErrorMessage;
import menu.utils.Food;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CoachTest {

    @Test
    void Couch_객체의_이름이_2글자_4글자_사이가_아니면_예외() {
        Assertions.assertThatThrownBy(() -> Coach.from("김"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_NAME_OUT_OF_RANGE.getMessage());
    }

    @Test
    void Couch_객체의_이름은_앞뒤_공백을_무시한다() {
        Coach coach = Coach.from(" 최최준호 ");
        Assertions.assertThat(coach.getName()).isEqualTo("최최준호");
    }

    @Test
    void recommend_메소드를_실행하면_해당_Food에_대해_isDeny_True() {
        Coach coach = Coach.from("최준호");
        coach.recommend(Food.가츠동);
        Assertions.assertThat(coach.isDeny(Food.가츠동)).isTrue();
    }

    @Test
    void recommend_메소드를_실행하면_해당_Food가_toMessage에_포함() {
        Coach coach = Coach.from("최준호");
        coach.recommend(Food.가츠동);
        Assertions.assertThat(coach.toMessage()).contains(Food.가츠동.getAlias());
    }

    @Test
    void denyFood_메소드를_실행하면_해당_Food에_대해_isDeny_True() {
        Coach coach = Coach.from("최준호");
        coach.denyFood(List.of(Food.가츠동));
        Assertions.assertThat(coach.isDeny(Food.가츠동)).isTrue();
    }

    @Test
    void denyFood_메소드를_중복해서_실행하면_예외() {
        Coach coach = Coach.from("최준호");
        coach.denyFood(List.of(Food.가츠동));
        Assertions.assertThatThrownBy(() -> {
                    coach.denyFood(List.of(Food.고추잡채));
                }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.COACH_ALREADY_DENY_FOOD.getMessage());
    }

}