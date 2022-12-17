package menu.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryServiceImplTest {

    private final CategoryServiceImpl service = new CategoryServiceImpl();
    private static final Integer CATEGORY_COUNT = 5;


    @Test
    void 카테고리목록_불러오기성공() {
        // given

        // when
        List<String> categories = service.getCategories();

        // then
        Assertions.assertThat(categories.size()).isEqualTo(CATEGORY_COUNT);
    }
}
