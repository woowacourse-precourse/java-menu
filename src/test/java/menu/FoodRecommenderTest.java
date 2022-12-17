package menu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class FoodRecommenderTest {

//    @Test
//    void pickCategory() {
//        FoodRecommender test = new FoodRecommender();
//        for (int i = 0; i < 8; i++) {
//            System.out.println(test.pickCategory());
//        }
//    }
//
//    @Test
//    void 메뉴_잘_고르는지_테스트() {
//        List<String> japanCandidate = List.of(new String[]{"규동", "우동", "미소시루", "오니기리", "하이라이스", "라멘", "오코노미야끼"});
//        String[] hate = {"스시", "가츠동"};
//        Coach testCoach = new Coach("dd", hate);
//        FoodRecommender testRecommender = new FoodRecommender();
//        for (int i = 0; i < 7; i++) {
//            testRecommender.pickMenu(testCoach, "일식");
//        }
//        assertThat(testCoach.checkIsAteMenu("스시")).isFalse();
//        assertThat(testCoach.checkIsAteMenu("가츠동")).isFalse();
//        for (String strI : japanCandidate) {
//            assertThat(testCoach.checkIsAteMenu(strI)).isTrue();
//        }
//    }
}