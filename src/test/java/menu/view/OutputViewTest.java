package menu.view;

import menu.dto.CoachNameDto;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void printReadCoachNames() {
        CoachNameDto coachNameDto = new CoachNameDto("토미");
        OutputView.printReadCantEatMenus(coachNameDto);
    }
}