package menu.generator;

import menu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CategoryGeneratorTest {
    HashMap<Category, Integer> categoryCounter;
    CategoryGenerator categoryGenerator;
    @BeforeEach
    void init(){
        categoryCounter = new HashMap<>();
        categoryGenerator = new CategoryGenerator();
        categoryCounter.put(Category.ASIA, 2);
        categoryCounter.put(Category.KOREA, 2);
        categoryCounter.put(Category.JAPAN, 2);
        categoryCounter.put(Category.AMERICA, 2);
        categoryCounter.put(Category.CHINA, 0);
    }
    @DisplayName("두 번이상 고른 카테고리가 존재할 시 다시 뽑는 기능")
    @Test
    void pick() {
        int flag = 0;
        while(flag < 2){
            Category pick = categoryGenerator.pick(categoryCounter);
            Assertions.assertThat(pick).isEqualTo(Category.CHINA);
            flag++;
        }
    }
}