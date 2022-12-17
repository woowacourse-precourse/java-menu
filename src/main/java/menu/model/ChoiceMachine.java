package menu.model;

import menu.enums.MenuOption;

public class ChoiceMachine {

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    public void choiceCategory() {
        String category;
        do {
            category = randomMenuGenerator.randomCategoryChoice();
        } while (!CoachRepository.canAddCategory(category));

        CoachRepository.addCategory(MenuOption.fromCategory(category));
    }
}
