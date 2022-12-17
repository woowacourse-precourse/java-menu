package menu.model;

import menu.enums.MenuOption;
import menu.utils.RandomGenerator;

public class ChoiceMachine {

    RandomGenerator randomGenerator = new RandomGenerator();

    public void choiceCategory() {
        String category;
        do {
            category = randomGenerator.randomCategoryChoice();
        } while (!CoachRepository.canAddCategory(category));

        CoachRepository.addCategory(MenuOption.fromCategory(category));
    }
}
