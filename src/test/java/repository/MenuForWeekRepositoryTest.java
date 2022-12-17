package repository;

import constant.Category;
import constant.Week;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuForWeekRepositoryTest {
    @Test
    public void testIsCategoryAvailableToAdd() {
        assertThat(MenuForWeekRepository.isCategoryAvailableToAdd(Category.AMERICAN_FOOD))
                .isTrue();
    }

//    @Test
//    public void testIsCategoryAvailableToAdd_추가못하는경우() {
//        MenuForWeekRepository.addCategory(Week.MONDAY, Category.AMERICAN_FOOD);
//        MenuForWeekRepository.addCategory(Week.TUESDAY, Category.AMERICAN_FOOD);
//        assertThat(MenuForWeekRepository.isCategoryAvailableToAdd(Category.AMERICAN_FOOD))
//                .isFalse();
//    }
//
//    @Test
//    public void testIsCategoryAvailableToAdd_추가못하는경우() {
//        MenuForWeekRepository.addCategory(Week.MONDAY, Category.AMERICAN_FOOD);
//        MenuForWeekRepository.addCategory(Week.TUESDAY, Category.AMERICAN_FOOD);
//        assertThat(MenuForWeekRepository.isCategoryAvailableToAdd(Category.AMERICAN_FOOD))
//                .isFalse();
//    }
}