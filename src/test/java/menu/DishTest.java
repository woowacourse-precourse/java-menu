package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DishTest {

    @Test
    @DisplayName("Dish enum 카테고리 선택")
    void menu() {
        List<String> result = Dish.pickCategory("중식");
        assertThat(result).contains("볶음면");
    }
}
