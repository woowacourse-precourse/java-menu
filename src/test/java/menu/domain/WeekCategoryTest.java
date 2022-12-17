package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WeekCategoryTest {
    @Test
    void 일주일_카테고리_반환() {
        WeekCategory weekCategory = WeekCategory.getInstance();
        List<Category> actual = weekCategory.getCategoriesOfWeek();
        actual.forEach(System.out::println);
    }
}
