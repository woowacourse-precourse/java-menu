package repository;

import constant.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MenuForWeekRepositoryTest {
    @Test
    public void testIsCategoryAvailableToAdd() {
        assertThat(MenuForWeekRepository.isCategoryAvailableToAdd(Category.AMERICAN_FOOD))
                .isTrue();
    }
}