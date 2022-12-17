package menu.controller;

import menu.domain.category.Category;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<String> readValidCoachNames() {
        return repeatUntilGettingValidValue(this::readCoachNames);
    }

    public Map<String, List<String>> readValidHateMenusByCoach(List<String> coachNames) {
        return repeatUntilGettingValidValue(this::readHateMenusByCoach, coachNames);
    }

    private List<String> readCoachNames() {
        outputView.printCoachNameInputGuide();
        return inputView.readCoachNames();
    }

    private Map<String, List<String>> readHateMenusByCoach(List<String> coachNames) {
        Map<String, List<String>> hateMenusByCoach = new LinkedHashMap<>();
        for (String coachName : coachNames) {
            hateMenusByCoach.put(coachName, readValidHateMenus(coachName));
        }
        return hateMenusByCoach;
    }

    private List<String> readValidHateMenus(String coachName) {
        return repeatUntilGettingValidValue(this::readHateMenus, coachName);
    }

    private List<String> readHateMenus(String coachName) {
        outputView.printHateMenuGuide(coachName);
        List<String> menus = inputView.readHateMenus();
        validateMenusName(menus);
        return menus;
    }

    private void validateMenusName(List<String> menus) {
        for (String menu : menus) {
            Category.validateMenuName(menu);
        }
    }

    private <T> T repeatUntilGettingValidValue(Supplier<T> getSomething) {
        while (true) {
            try {
                return getSomething.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private <T, R> R repeatUntilGettingValidValue(Function<T, R> getSomething, T name) {
        while (true) {
            try {
                return getSomething.apply(name);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
