package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoachTest {
    @DisplayName("추천할 메뉴가 못먹는 메뉴이면 예외")
    @Test
    void test1() {
        Coach coach = new Coach("12");
        coach.addNotEatingMenu("김치");
        coach.addNotEatingMenu("호박");

        assertThatThrownBy(() -> coach.addRecommandMenu("김치")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("못먹는 메뉴가 없다면")
    @Test
    void test2() {
        Coach coach = new Coach("12");

        coach.addRecommandMenu("우동");
        coach.addRecommandMenu("스시");
//        assertThatThrownBy(()->coach.addRecommandMenu("김치")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("같은 카테고리 3개 이상이면 예외 발생")
    @Test
    void test3() {
        Coach coach = new Coach("12");

        coach.addRecommandMenu("우동");
        coach.addRecommandMenu("스시");

        assertThatThrownBy(() -> coach.addRecommandMenu("규동")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("중복 메뉴추천인 경우 예외 발생")
    @Test
    void test4() {
        Coach coach = new Coach("12");

        coach.addRecommandMenu("우동");
        assertThatThrownBy(() -> coach.addRecommandMenu("우동")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("이름글자 2보다 작은 경우 예외 발생")
    @Test
    void test5() {
        assertThatThrownBy(() -> new Coach("1")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("이름글자 4보다 큰 경우 예외 발생")
    @Test
    void test6() {
        assertThatThrownBy(() -> new Coach("12345")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("못먹는 메뉴 3개 입력시")
    @Test
    void test7() {
        Coach coach = new Coach("11");
        coach.addNotEatingMenu("1");
        coach.addNotEatingMenu("2");

        assertThatThrownBy(() -> coach.addNotEatingMenu("3")).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("못먹는 메뉴 중복 입력시")
    @Test
    void test8() {
        Coach coach = new Coach("11");
        coach.addNotEatingMenu("1");

        assertThatThrownBy(() -> coach.addNotEatingMenu("1")).isInstanceOf(IllegalArgumentException.class);

    }
}
