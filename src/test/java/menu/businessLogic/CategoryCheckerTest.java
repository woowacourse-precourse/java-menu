package menu.businessLogic;

import menu.domains.Categories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryCheckerTest {

    private final CategoryChecker checker = new CategoryChecker();

    @Nested
    class CheckAndSuggestedCategoryTest{

        @DisplayName("하나도 카테고리에 입력되어 있지 않을 시 true 리턴")
        @Test
        void checkAndAddSuggestedCategory_case1() {
            List<Categories> suggestedCategory = new ArrayList<>();
            Categories newCategory = Categories.한식;
            assertThat(checker.checkAndAddSuggestedCategory(suggestedCategory,newCategory)).isTrue();
        }

        @DisplayName("새로 입력하는 카테고리가 모두 겹치지 않을 때 true 리턴")
        @Test
        void checkAndAddSuggestedCategory_case2() {
            List<Categories> suggestedCategory = new ArrayList<>(Arrays.asList(Categories.양식,Categories.일식));
            Categories newCategory = Categories.한식;
            assertThat(checker.checkAndAddSuggestedCategory(suggestedCategory,newCategory)).isTrue();
        }

        @DisplayName("새로 입력하는 카테고리가 하나 겹칠 때 true 리턴")
        @Test
        void checkAndAddSuggestedCategory_case3() {
            List<Categories> suggestedCategory = new ArrayList<>(Arrays.asList(Categories.한식,Categories.일식));
            Categories newCategory = Categories.한식;
            assertThat(checker.checkAndAddSuggestedCategory(suggestedCategory,newCategory)).isTrue();
        }

        @DisplayName("새로 입력하는 카테고리가 두 개 이상 겹칠 때 false 리턴")
        @Test
        void checkAndAddSuggestedCategory_case4() {
            List<Categories> suggestedCategory = new ArrayList<>(Arrays.asList(Categories.한식,Categories.일식,Categories.한식));
            Categories newCategory = Categories.한식;
            assertThat(checker.checkAndAddSuggestedCategory(suggestedCategory,newCategory)).isFalse();
        }
    }
}