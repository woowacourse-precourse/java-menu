package menu.model;

import menu.enums.MenuOption;
import menu.module.NotModule;

public class ChoiceMachine extends NotModule {

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    public void choiceCategory() {
        String category;
        do {
            category = randomMenuGenerator.randomCategoryChoice();
        } while (not(CoachRepository.canAddCategory(category)));

        CoachRepository.addCategory(MenuOption.fromCategory(category));
    }

    public void choiceMenu(Coach coach, int day) {
        String menu;
        do {
            menu = randomMenuGenerator.randomMenuChoice();
        } while (not(coach.canAddMenu(menu) && CoachRepository.canAddMenuInThisCategory(menu, day)));

        coach.addMenu(menu);
    }
}
