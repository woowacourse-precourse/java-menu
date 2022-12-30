package menu.model;

import menu.enums.MenuOption;
import menu.module.NotModule;

public class ChoiceMachine extends NotModule {

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    public MenuOption choiceCategory() {
        String category;
        do {
            category = randomMenuGenerator.randomCategoryChoice();
        } while (not(CoachRepository.canAddCategory(category)));

        CoachRepository.addCategory(MenuOption.fromCategory(category));

        return MenuOption.fromCategory(category);
    }

    public void choiceMenu(Coach coach, MenuOption menuOption) {
        String menu;
        do {
            menu = randomMenuGenerator.randomMenuChoice();
        } while (not(menuOption.isContainsInCategroy(menu)) || not(coach.canAddMenu(menu)));

        coach.addMenu(menu);
    }
}
