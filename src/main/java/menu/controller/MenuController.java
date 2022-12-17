package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.Menu;
import menu.domain.MenuRepository;
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
        String coachName = coach.getCoachName();
        List<String> dislikeMenusName = InputView.inputDislikeMenus(coachName);
        return dislikeMenusName.stream()
                .map(MenuRepository::findByName)
                .collect(Collectors.toUnmodifiableList());
    }
}
