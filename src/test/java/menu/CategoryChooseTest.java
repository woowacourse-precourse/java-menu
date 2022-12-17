package menu;

import menu.resource.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryChooseTest {

    CategoryChoose categoryChoose = new CategoryChoose();

    @Test
    void 랜덤_메뉴_선정(){
        Category category = categoryChoose.getRandomCategory();
        System.out.println(category.getName());
        List<Category> categorys = List.of(Category.values());
        assertTrue(categorys.contains(category));
    }


}