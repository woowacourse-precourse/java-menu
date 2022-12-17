package menu.domain;

import static menu.constant.Food.나시고렝;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.RepeatedTest;

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

    private void recommendFoods(Coach coach) {
        for (int i = 0; i < 5; i++) {
            coach.pickFrom(Category.ASIAN);
        }
    }
}