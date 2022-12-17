package menu;

import menu.domain.Coach;
import menu.domain.Food;
import menu.resource.Category;
import menu.resource.Day;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {
    Coach coach = new Coach("유성욱");
    Food food = new Food("비빔밥", Category.KOREA);

    @Test
    void 중복_음식(){
        coach.addNewFood(Day.MONDAY,"비빔밥");
        assertTrue(!coach.ifFoodDuplicate("비빔밥"));
    }

}