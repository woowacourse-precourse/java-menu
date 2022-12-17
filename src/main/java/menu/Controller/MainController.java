package menu.Controller;

import menu.Model.Coach;
import menu.Model.Coaches;
import menu.View.InputView;
import menu.View.OutputView;

import java.util.List;

public class MainController {
    private final Coaches coaches;
    private final RecommendController recommend;

    public MainController() {
        coaches = new Coaches();
        recommend = new RecommendController(coaches);
    }

    public void run() {
        OutputView.printRecommendStart();
        initCoaches();
        initNotPreferMenu();
        recommend.recommendStart();

    }


    private void initCoaches() {
        String input = InputView.requestCoachName();
        List<String> coachNames = List.of(input.split(","));
        for (String e : coachNames) {
            Coach coach = new Coach(e);
            this.coaches.addCoach(coach);
        }
    }

    private void initNotPreferMenu() {
        for (Coach coach : coaches.getCoaches()) {
            String input = InputView.requestNotPreferMenu(coach.getName());
            List<String> notPreferMenuNames = List.of(input.split(","));
            for (String e : notPreferMenuNames) {
                coach.addNotPreferMenu(e);
            }
        }
    }

}
