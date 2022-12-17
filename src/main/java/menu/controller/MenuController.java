package menu.controller;

import menu.model.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        outputView.printInit();
        CoachGroup coachGroup = input(CoachGroup::new, inputView::inputCoachName);

        List<Coach> coaches = createCoaches(coachGroup);

        for (Coach coach : coaches) {
            Recommend recommend = new Recommend(coach);
            Category recommendCategory = recommend.recommendCategory();
            String menu = recommend.recommendMenu(recommendCategory);
            coach.addRecommendMenu(Menu.from(menu));
        }

        outputView.printResult( coachGroup.makeResult());
    }

    private List<Coach> createCoaches(CoachGroup coachGroup) {
        List<Coach> coaches = coachGroup.getCoaches();
        for (Coach coach : coaches) {
            List<Menu> menus = input(Menu::makeMenus, () -> inputView.inputMenu(coach.getName()));
            coach.setNonMenus(menus);
        }
        return coaches;
    }

    public <T, R> R input(Function<T, R> function, Supplier<T> supplier) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.printErrorMessage(e);
            return input(function, supplier);
        }
    }
}
