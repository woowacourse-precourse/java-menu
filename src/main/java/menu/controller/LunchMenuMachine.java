package menu.controller;

import menu.constants.CategoryAndMenuDefinition;
import menu.domain.DayCategory;
import menu.domain.MenuMaker;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LunchMenuMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuMaker menuMaker;

    public LunchMenuMachine(InputView inputView,
                            OutputView outputView, MenuMaker menuMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuMaker = menuMaker;
    }

    public void run() {
        outputView.printStartMessage();

        String coachName = inputView.coachNameInput();
        List<String> coachNames = menuMaker.nameDivision(coachName);

        HashMap<String, String> coachMenus = menuMaker.menuDivision(coachNames);

        CategoryAndMenuDefinition categoryAndMenuDefinition = new CategoryAndMenuDefinition();
        categoryAndMenuDefinition.Category();


        DayCategory dayCategory = new DayCategory();
        List<String> randomCategoryFood = dayCategory.randomCategory();

    }
}
