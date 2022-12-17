package menu.domain;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> hateMenu;

    public Coach(String name) {
        this.name = name;
        this.hateMenu = new ArrayList<>();
    }

    public void checkHateMenu() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputCoachHateMenu(this.name);
        this.hateMenu.addAll(Arrays.asList(inputView.readHateMenu()));
    }
}
