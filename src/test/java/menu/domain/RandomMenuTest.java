package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.utill.CategoryMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomMenuTest {
    @Nested
    @DisplayName("select 메소드")
    class Describe_select {
        @Test
        void selectTest() {
            String name = "토미";
            List<KindAndFood> kindAndFoods = new ArrayList<>();

            List<String> hateFoods = Arrays.asList("우동", "비빔밥");

            Human human = new Human(name, kindAndFoods, hateFoods);
            RandomMenu randomMenu = new RandomMenu();
            randomMenu.select(human, CategoryMaker.make());
            List<KindAndFood> result = human.getKindAndFoods();
            result.stream()
                    .forEach(ele -> {
                        System.out.println(ele.getCategory());
                        System.out.println(ele.getFood().getFood());
                    });

        }
    }


}
