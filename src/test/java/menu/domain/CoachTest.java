package menu.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    Coach coach;

    @BeforeEach
    void init() {
        coach = new Coach("미성");
        coach.addRecommendedMenu("김밥");
        coach.addRecommendedMenu("뇨끼");
        coach.addRecommendedMenu("우동");
    }

    void inputFromUser(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("추천받은 메뉴가 못먹는 메뉴인지 확인")
    @Test
    void isHateMenu() {
        inputFromUser("규동,스파게티");
        coach.checkHateMenu();
        assertTrue(coach.isHateMenu("규동"));
        assertFalse(coach.isHateMenu("우동"));

    }

    @DisplayName("이미 추천된 메뉴인지 확인")
    @Test
    void isRecommendedMenu() {
        assertTrue(coach.isRecommendedMenu("김밥"));
        assertFalse(coach.isRecommendedMenu("나시고렝"));
    }
}