package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.controller.CoachController;
import menu.controller.RecommendController;
import menu.domain.Category;
import menu.controller.CategoryController;
import menu.domain.Coach;
import menu.ui.Output;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecommendTest {
    @Test
    void makeCategoryList() {
        CategoryController categoryController = new CategoryController();
        List<Category> categorys = categoryController.getCategorys();

        Assertions.assertThat(categorys.size()).isEqualTo(5);
    }

    @Test
    void menuInitTest() {
        CategoryController categoryController = new CategoryController();
        List<Category> categorys = categoryController.getCategorys();
        for (Category category : categorys) {
            List<String> menu = category.getMenu();
            Assertions.assertThat(menu.size()).isNotEqualTo(0);
        }
        Assertions.assertThat(categorys.get(0).getMenu().size()).isEqualTo(9);
    }

    @Test
    void test() {
        RecommendController recommendController = new RecommendController();
        CategoryController categoryController = new CategoryController();
        List<Category> categorys = categoryController.getCategorys();

        String result = "";
        for (Category category : categorys) {
            if (category.getName().equals("한식")) {
               result =  recommendController.selectRecommendFood(category);
            }
        }
        System.out.println("result = " + result);
    }

    @Test
    void randompick() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Randoms.pickNumberInRange(0, 4));
        }

    }
}
