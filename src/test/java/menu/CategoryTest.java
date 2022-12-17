package menu;

import java.util.List;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Weekend;
import menu.repository.MenuRepository;
import menu.repository.WeekendRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {


    @Test
    void 카테고리_생성_테스트() {
        int number = 1;
        Category category = Category.findByCommand(number);
        Assertions.assertThat(category.getName()).isEqualTo("일식");
    }



}
