package menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Control {
    private final InputView inputView;
    private final OutputView outputView;
    private final Menu menu;
    private Recommendation recommendation;
    private final List<String> categorySchedule;
    private List<String> coachNames;
    private Map<String, List<String>> coachInedible;

    public Control() {
        Category category = new Category();
        this.menu = new Menu();
        this.categorySchedule = category.makeSchedule();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void initialization() {
        inputView.initialization();
        System.out.println();
        String names = inputView.coachName();
        List<String> coachNames = Arrays.asList(names.split(","));

        this.coachNames = coachNames;
    }

    public void getInedible(List<String> coachNames) {
        for(String s : coachNames) {
            String inedible = inputView.coachInedibleMenu(s);
            this.coachInedible.put(s, Arrays.asList(inedible));
        }
        this.recommendation = new Recommendation(coachInedible);
    }

    public void makeRecommendation(List<String> coachNames, String category) {
        for (String s : coachNames) {
            String recommend;
            do {
                recommend = menu.getMenu(category);
            } while (recommendation.addMenu(s, recommend));
        }
    }

    public void totalRecommendation(List<String> coachNames, List<String> categorySchedule) {
        for (String s : categorySchedule) {
            makeRecommendation(coachNames, s);
        }
    }

    public void menuRound() {
        initialization();
        getInedible(coachNames);
        totalRecommendation(coachNames, categorySchedule);
        Map<String, List<String>> recommendation = this.recommendation.get();
        outputView.printCategory(categorySchedule);
        for (String s : coachNames) {
            outputView.coachMenu(s, recommendation.get(s));
        }
        outputView.printFinish();
    }
}