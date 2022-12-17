package menu.domain;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoachTest {
    private Coach coach;

    @BeforeEach
    void setCoach() {
        coach = new Coach(new CoachName("제준"), List.of("족발", "시간"));
    }

    @Test
    void coach_already_eat_menu_test() {
        assertTrue(coach.canEat("배달의민족주문!"));
        coach.eat("배달의민족주문!");
        assertFalse(coach.canEat("배달의민족주문!"));
    }
}