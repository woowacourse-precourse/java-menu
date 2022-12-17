package menu.domain.results;

import menu.domain.menu.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecommendCategoriesTest {

    @Test
    public void 추천_카테고리의_중복은_최대_2개만_가능하다() {
        RecommendCategories recommendCategories = new RecommendCategories();
        recommendCategories.addRecommendCategory(MenuCategory.JAPANESE);
        recommendCategories.addRecommendCategory(MenuCategory.JAPANESE);
        recommendCategories.addRecommendCategory(MenuCategory.JAPANESE);

        Assertions.assertThat(recommendCategories.getCategories()).hasSize(2);
    }

    @Test
    public void 추천_카테고리_출력_테스트() {
        RecommendCategories recommendCategories = new RecommendCategories();
        recommendCategories.addRecommendCategory(MenuCategory.JAPANESE);
        recommendCategories.addRecommendCategory(MenuCategory.FRENCH);
        recommendCategories.addRecommendCategory(MenuCategory.KOREAN);
        recommendCategories.addRecommendCategory(MenuCategory.ASIAN);
        recommendCategories.addRecommendCategory(MenuCategory.FRENCH);

        String expected = "[ 카테고리 | 일식 | 양식 | 한식 | 아시안 | 양식 ]";
        Assertions.assertThat(recommendCategories.resultFormat()).isEqualTo(expected);
    }

}