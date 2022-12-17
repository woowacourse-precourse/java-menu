package menu;

import menu.domain.Coach;
import menu.domain.Food;
import menu.resource.Category;
import menu.resource.Day;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {
    private static  String BIBIM = "비빔밥";
    Coach coach = new Coach("유성욱");
    Food food = new Food(BIBIM, Category.KOREA);

    @Test
    void 중복_음식(){
        coach.addNewFood(Day.MONDAY,BIBIM);
        assertTrue(!coach.ifFoodDuplicate(BIBIM));
    }

    @Test
    void 못먹는_음식_검사(){
        coach.addCantEatFood(food);
        assertTrue(!coach.ifNotIncludeInCantEat(BIBIM));
    }

}