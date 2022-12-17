package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CouchTest {

    @Test
    void Couch_객체의_이름이_2글자_4글자_사이가_아니면_예외() {
        Assertions.assertThatThrownBy(() -> Couch.from("김"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUCH_NAME_OUT_OF_RANGE.getMessage());
    }

    @Test
    void Couch_객체의_이름은_앞뒤_공백을_무시한다() {
        Couch couch = Couch.from(" 최최준호 ");
        Assertions.assertThat(couch.getName()).isEqualTo("최최준호");
    }

    @Test
    void recommend_메소드를_실행하면_해당_Food에_대해_isDeny_True() {
        Couch couch = Couch.from("최준호");
        couch.recommend(Food.가츠동);
        Assertions.assertThat(couch.isDeny(Food.가츠동)).isTrue();
    }

    @Test
    void recommend_메소드를_실행하면_해당_Food가_toMessage에_포함() {
        Couch couch = Couch.from("최준호");
        couch.recommend(Food.가츠동);
        Assertions.assertThat(couch.toMessage()).contains(Food.가츠동.getAlias());
    }

    @Test
    void denyFood_메소드를_실행하면_해당_Food에_대해_isDeny_True() {
        Couch couch = Couch.from("최준호");
        couch.denyFood(List.of(Food.가츠동));
        Assertions.assertThat(couch.isDeny(Food.가츠동)).isTrue();
    }

    @Test
    void denyFood_메소드를_중복해서_실행하면_예외() {
        Couch couch = Couch.from("최준호");
        couch.denyFood(List.of(Food.가츠동));
        Assertions.assertThatThrownBy(() -> {
                    couch.denyFood(List.of(Food.고추잡채));
                }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.COUCH_ALREADY_DENY_FOOD.getMessage());
    }

}