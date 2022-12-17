package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryDeciderTest {

    @DisplayName("카테고리를 10번 선택하면 각 카테고리가 2번씩 선택된다.")
    @Test
    void setCategory() {
        CategoryDecider categoryDecider = new CategoryDecider();
        for(int i = 0; i<10; i++) {
            categoryDecider.setCategory();
        }
        System.out.println(categoryDecider.makeResultMessage());
    }
}