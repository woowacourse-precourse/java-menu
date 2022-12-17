package menu.model;

import menu.enums.MenuOption;
import menu.module.NotModule;

import java.util.ArrayList;
import java.util.List;

public class ChoiceMachine extends NotModule {

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    public void choiceCategory() {
        String category;
        do {
            category = randomMenuGenerator.randomCategoryChoice();
        } while (not(CoachRepository.canAddCategory(category)));

        CoachRepository.addCategory(MenuOption.fromCategory(category));
    }

    public void choiceMenu(Coach coach, MenuOption category) {
        List<String> addableMenus = category.getAddableMenus(coach.getChoicedMenus(), coach.getHateFoods());
        String menu = randomMenuGenerator.randomMenuChoice(addableMenus);
        System.out.println(addableMenus + " " + menu);

        coach.addMenu(menu);
    }
}
