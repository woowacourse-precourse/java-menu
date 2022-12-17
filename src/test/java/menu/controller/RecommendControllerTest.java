package menu.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.model.Category;
import menu.model.Menu;
import org.junit.jupiter.api.Test;

class RecommendControllerTest {
//
//    @Test
//    void getFiveCategories() {
//        RecommendController recommendController = new RecommendController();
//        List<Category> categories = recommendController.getFiveCategories();
//        Set<Category> actual = new HashSet<>();
//        assertThat(categories.size()).as("사이즈가 5인지").isEqualTo(5);
//        for (Category category : categories) {
//            actual.add(category);
//            assertThat(category).as("카테고리가 맞는지").isInstanceOf(Category.class);
//        }
//    }
//
//    @Test
//    void recommendMenu() {
//        RecommendController recommendController = new RecommendController();
//        Menu actual = recommendController.recommendMenuByCategory(Category.Korean);
//        assertThat(actual.getCategory()).isEqualTo(Category.Korean);
//    }
}