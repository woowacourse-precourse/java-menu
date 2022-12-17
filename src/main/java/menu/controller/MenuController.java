package menu.controller;

import menu.domain.*;
import menu.domain.generator.RandomCategoryGenerator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {

    public MenuController() {
        initMenus();
    }

    public void run() {
        OutputView.printServiceStartMessage();
        addCoaches();
        addCoachesDislikeMenus();
        recommend();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker();
        menuMaker.makeMenus();
    }

    private void addCoaches() {
        try {
            List<String> coachesName = InputView.inputCoachesName();
            CoachRepository.addCoaches(coachesName);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            CoachRepository.clearCoaches();
            addCoaches();
        }
    }

    private void addCoachesDislikeMenus() {
        CoachRepository.getCoaches().forEach(coach -> {
            CoachRepository.addDislikeMenus(coach, getDislikeMenus(coach));
        });

    }

    private List<Menu> getDislikeMenus(Coach coach) {
        try {
            List<String> dislikeMenusName = InputView.inputDislikeMenus(coach.getCoachName());
            return dislikeMenusName.stream()
                    .map(MenuRepository::findByName)
                    .collect(Collectors.toUnmodifiableList());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getDislikeMenus(coach);
        }
    }

    private void recommend() {
        RecommendMaker recommendMaker = new RecommendMaker(new RandomCategoryGenerator());
        recommendMaker.recommend();
    }
}
