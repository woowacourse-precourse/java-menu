package menu.domain;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> hateMenu;
    private final List<String> recommendedMenu;

    public Coach(String name) {
        this.name = name;
        this.hateMenu = new ArrayList<>();
        this.recommendedMenu = new ArrayList<>();
    }

    public void checkHateMenu() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputCoachHateMenu(this.name);
        this.hateMenu.addAll(Arrays.asList(inputView.readHateMenu()));
    }

    public boolean isHateMenu(String menu) {
        return this.hateMenu.contains(menu);
    }

    public boolean isRecommendedMenu(String menu) {
        return this.recommendedMenu.contains(menu);
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenu.add(menu);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getRecommendedMenu() {
        return Collections.unmodifiableList(recommendedMenu);
    }
}
