package menu;

import menu.domain.FoodCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTest {
    @Test
    @DisplayName("Enum 값 테스트")
    void enum_Test(){
        FoodCategory test = FoodCategory.양식;
        System.out.println(test.name());
    }
}
