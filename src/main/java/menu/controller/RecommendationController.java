package menu.controller;

import static menu.controller.CategoryRegister.getMenus;
import static menu.view.OutputView.printCategory;
import static menu.view.OutputView.printResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.CategoryNumberGenerator;
import menu.domain.CategoryRandomNumberGenerator;
import menu.domain.Coach;
import menu.domain.MatchingCategory;
import menu.view.InputView;

public class RecommendationController {

//    private List<Coach> coachs;

    public RecommendationController() {
        CategoryRegister.MenuListSave();
    }

    public void startRecommendation() {
        List<String> names = new ArrayList<>();
        List<Coach> coaches = new ArrayList<>();
        names = InputView.readCoachName();
        for (String coachName : names) {
            List<String> dislikeMenus = new ArrayList<>(InputView.readDislikeMenu(coachName));
            Coach coach = new Coach(coachName, dislikeMenus);
            coaches.add(coach);
        }
        printResult();
        runRecommendation(coaches);

    }

    private void runRecommendation(List<Coach> coaches) {
        CategoryNumberGenerator categoryNumberGenerator = new CategoryRandomNumberGenerator();
        for (int i = 0; i < 5; i++) {
            MatchingCategory matchingCategory = new MatchingCategory(
                    categoryNumberGenerator.generate());
            String Category = matchingCategory.getCategory();
            List<String> recommendedResult = new ArrayList<>();
            recommendedResult.add(matchingMenu(Category));
            addRecommendResult(coaches, recommendedResult);
        }
        printResults(coaches);
    }

    private void printResults(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printCategory(coach.getRecommendMenus());
        }
    }

    private void addRecommendResult(List<Coach> coaches, List<String> recommendedResult) {
        for (Coach coach : coaches) {
            coach.setRecommendMenus(recommendedResult);
        }
    }

    private String matchingMenu(String Category) {
        String currentmenu = Randoms.shuffle(getMenus(Category)).get(0);
        return currentmenu;
    }
}
