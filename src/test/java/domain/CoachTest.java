package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("못 먹는 메뉴가 유효한지 검증다")
    //given
    @ValueSource(strings = {"ㅁ", "된장찌개,불고기,하이라이스"})
    @ParameterizedTest
    void invalidMenu(String strings) {
        assertThatThrownBy(() -> {
            Coach coach = new Coach("합격");
            coach.addInedibleMenu(strings);
        }).isInstanceOf(
            IllegalArgumentException.class);
    }
}