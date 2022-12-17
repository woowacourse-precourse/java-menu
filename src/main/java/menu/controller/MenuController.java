package menu.controller;

import java.util.List;
import menu.domain.CategoryRecommend;
import menu.domain.Coach;
import menu.domain.MenuRecommend;
import menu.domain.Weekday;
import menu.repository.CategoryRecommendRepository;
import menu.repository.CoachRepository;
import menu.repository.MenuRecommendRepository;
import menu.resource.Data;
import menu.view.InputVIew;
import menu.view.OutputView;

public class MenuController {

    public static void run() {
        OutputView.printIntro();
        Data.loadData();
        setCoaches();
        setCannotEatMenus();
        makeRecommend();
        OutputView.printResult();
        OutputView.printOutro();
    }

    private static void setCoaches() {
        try {
            List<String> coachNames = InputVIew.readCoachNames();
            for (String name : coachNames) {
                CoachRepository.addCoaches(new Coach(name));
            }
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setCoaches();
        }
    }

    private static void setCannotEatMenus() {
        for (Coach coach : CoachRepository.getCoaches()) {
            setMenusOnCoach(coach);
        }
    }

    private static void setMenusOnCoach(Coach coach) {
        try {
            List<String> menus = InputVIew.readCannotEatMenus(coach);
            coach.updateFoods(menus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setMenusOnCoach(coach);
        }
    }

    private static void makeRecommend() {
        for (Weekday weekday : Weekday.getOrderedWeekdays()) {
            CategoryRecommend categoryRecommend = new CategoryRecommend(weekday);
            CategoryRecommendRepository.addRecommend(categoryRecommend);
            for (Coach coach : CoachRepository.getCoaches()) {
                MenuRecommend menuRecommend = new MenuRecommend(categoryRecommend, coach);
                MenuRecommendRepository.addRecommend(menuRecommend);
            }
        }
    }
}
