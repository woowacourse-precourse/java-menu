package menu;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import menu.domain.Category;
import menu.domain.Menu;
import menu.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuRepositoryTest {
    @Test
    void 메뉴_이름으로_찾기_테스트(){
        Menu menu =MenuRepository.findByMenuName("탕수육");
        assertThat(menu.getCategory()).isEqualTo(Category.CHINESE_FOOD);
    }
}
