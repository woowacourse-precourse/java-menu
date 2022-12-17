package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoachTest {
    Coach coach;
    @BeforeEach
    void init(){
        coach = new Coach("이준현");
    }
    @DisplayName("정상적으로 객체의 이름을 가져오는지 확인")
    @Test
    void getName() {
        assertThat(coach.getName()).isEqualTo("이준현");
    }

    @DisplayName("싫어하는 메뉴가 정상적으로 설정되는 지")
    @Test
    void setHateMenu() {
        List<String> hateMenu = new ArrayList<>();
        hateMenu.add("스시");
        hateMenu.add("우동");
        coach.setHateMenu(hateMenu);
        assertThat(coach.getHateMenu()).isEqualTo(hateMenu);
    }
    @DisplayName("먹은 메뉴를 입력했을떄 정상적으로 저장되는지 확인")
    @Test
    void addEatenMenu() {
        coach.addEatenMenu("스시");
        assertThat(coach.getEatenMenu()).contains("스시");
    }
}