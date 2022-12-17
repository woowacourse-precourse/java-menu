package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendProgram {

    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryRandomRecommender categoryRandomRecommender;
    private Coaches coaches;
    private List<String> categories;

    public MenuRecommendProgram() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.categoryRandomRecommender = new CategoryRandomRecommender();
        this.coaches = new Coaches();
        this.categories = new ArrayList<>();
    }

    public void start() {
        outputView.printStartMessage();
        outputView.printInputCoachName();
        makeCoach(inputView.readCoachName());
        checkHateMenu(this.coaches.getCoaches());
        for (int i = 0; i < 5; i++) {
            categories.add(categoryRandomRecommender.recommend(categories));
        }
    }

    private void makeCoach(String[] coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coach : coachNames) {
            coaches.add(new Coach(coach));
        }

        this.coaches.setCoaches(coaches);
    }

    private void checkHateMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coach.checkHateMenu();
        }
    }
}
