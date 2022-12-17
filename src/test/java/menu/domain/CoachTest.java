package menu.domain;

import static menu.constant.Food.규동;
import static menu.constant.Food.나시고렝;
import static menu.constant.Food.라멘;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import menu.constant.Category;

class CoachTest {

    @RepeatedTest(100)
    void 먹었던_음식은_다시_고르면_안된다() {
        Coach coach = new Coach("이름", List.of());

        recommendFoods(coach);
        assertThat(coach.getRecommendedFoods()).doesNotHaveDuplicates();
    }

    @RepeatedTest(100)
    void 못먹는_음식은_고르면_안된다() {
        Coach coach = new Coach("이름", List.of(나시고렝));

        recommendFoods(coach);
        assertThat(coach.getRecommendedFoods()).doesNotContain(나시고렝);
    }

    @Test
    void 못_먹는_메뉴_개수는_0이상_2이하이다() {
        assertThatNoException().isThrownBy(() -> new Coach("이름", List.of(나시고렝)));
    }

    @Test
    void 잘못된_못먹는_메뉴_개수는_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Coach("이름", List.of(나시고렝, 라멘, 규동)));
    }

    private void recommendFoods(Coach coach) {
        for (int i = 0; i < 5; i++) {
            coach.pickFrom(Category.ASIAN);
        }
    }
}