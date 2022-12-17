package menu.Controller;

import menu.Domain.Coach;
import menu.Domain.CoachRepository;
import menu.Domain.MenuRepository;
import menu.View.InfoMessages;
import menu.View.InputView;
import menu.View.OutputView;

import java.util.List;

public class ServiceController {

    public static void run() {
        initiate();

        readCoachList();
        readUnfavoredMenuList();

        RecommendationController.run();

        OutputView.printCategories();
        OutputView.printRecommendedMenus();
    }

    private static void initiate() {
        InfoMessages.START.println();
        MenuRepository.addInitialMenuList();
    }

    private static void readCoachList() {
        List<String> coachNames;
        try {
            coachNames = InputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoachList();
            return;
        }
        CoachRepository.addCoaches(coachNames);
    }

    private static void readUnfavoredMenuList() {
        for (Coach coach : CoachRepository.getCoachList()) {
            readFromCoach(coach);
        }
    }

    private static void readFromCoach(Coach coach) {
        List<String> unfavorMenuList;
        System.out.print(coach.getName());
        InfoMessages.INPUT_EXCLUDE_MENUS.println();
        try {
            unfavorMenuList = InputView.readUnfavorMenuList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readFromCoach(coach);
            return;
        }
        if (!unfavorMenuList.isEmpty()) {
            CoachRepository.addUnfavorMenuList(coach, unfavorMenuList);
        }
    }
}
