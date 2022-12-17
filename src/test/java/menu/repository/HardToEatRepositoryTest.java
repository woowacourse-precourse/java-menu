package menu.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HardToEatRepositoryTest {

    @AfterEach
    void after() {
        HardToEatRepository.clear();
    }

    @DisplayName("못 먹는 음식을 저장하고 확인한다.")
    @Test
    void storeMenu() {
        Coach coach = new Coach("홍길동");
        String menu = "김밥";

        HardToEatRepository.addMenus(coach, menu);
        List<String> menus = HardToEatRepository.findByCoach(coach);

        assertThat(menus.size()).isEqualTo(1);
        assertThat(menus).containsExactly(menu);
    }

    @DisplayName("중복된 음식은 저장되지 않는다.")
    @Test
    void storeDuplicationMenu() {
        Coach coach = new Coach("홍길동");
        String menu1 = "김밥";
        String menu2 = "김밥";

        HardToEatRepository.addMenus(coach, menu1);
        HardToEatRepository.addMenus(coach, menu2);
        List<String> menus = HardToEatRepository.findByCoach(coach);

        assertThat(menus.size()).isEqualTo(1);
        assertThat(menus).containsExactly(menu1);
    }

    @DisplayName("초기화하면 아무것도 남아있지 않는다.")
    @Test
    void clear() {
        Coach coach = new Coach("홍길동");
        String menu = "김밥";

        HardToEatRepository.addMenus(coach, menu);
        HardToEatRepository.clear();
        List<String> menus = HardToEatRepository.findByCoach(coach);

        assertThat(menus.size()).isEqualTo(0);
    }
}