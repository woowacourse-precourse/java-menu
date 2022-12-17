package menu;

import menu.domain.food.Category;
import menu.domain.food.CategoryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CategoryControllerTest {

    private CategoryController categoryController = new CategoryController();

    @BeforeEach
    void init() {
        CategoryFactory.makeFood();
    }

    @Test
    @DisplayName("코치 생성 성공")
    void test1() {
        String name = "홍시짱";
        List<String> cantEat = new ArrayList<>();
        categoryController.makeCoach(name, cantEat);
    }

    @Test
    @DisplayName("하루의 카테고리 고르기 성공")
    void test2() {
        Category category = categoryController.pickDayCategory();

        List<Category> categories = List.of(Category.JAPANESE, Category.KOREAN, Category.CHINESE, Category.ASIAN, Category.WESTERN);
        assertThat(categories).contains(category);
    }

    @Test
    @DisplayName("5일간의 카테고리 고르기 성공")
    void test3() {
        List<Category> categories = categoryController.makeRecommendMenu();
        assertThat(categories).hasSize(5);
    }
}
