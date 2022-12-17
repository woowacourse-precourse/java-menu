package menu;

import menu.model.CategoryMachine;
import menu.model.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class CategoryMachineTest {
    private Coach coach;
    private CategoryMachine categoryMachine;
    @BeforeEach
    void setting() {
        coach = new Coach("전동혁");
        categoryMachine = new CategoryMachine();
    }

    @DisplayName("같은 카테고리 음식 최대 2개 테스트")
    @Test
    void 같은_카테고리_음식_최대_2개_테스트() {
        categoryMachine.selectCategory(coach);
        int max = 0;
        for(int number = 1; number < 6; number++) {
            max = Math.max(Collections.frequency(coach.getCategory(), number), max);
        }
        Assertions.assertThat(max).isLessThan(3);
    }

}
