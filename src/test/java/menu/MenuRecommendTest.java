package menu;

import menu.domain.Food;
import menu.resource.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRecommendTest {
    MenuRecommend menuRecommend = new MenuRecommend();
    MenuGame menuGame = new MenuGame();
    List<Food> foods = menuGame.getFoods();
    @Test
    void 카테고리_분류(){
        List<Food> categoryFood = menuRecommend.getSpecificCategoryFood(foods, Category.ASIAN);
        for(int i=0;i<categoryFood.size();i++){
            Assertions.assertThat(categoryFood.get(i).getCategory()).isEqualTo(Category.ASIAN);
        }
    }

}