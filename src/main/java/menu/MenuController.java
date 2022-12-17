package menu;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public class MenuController {
    private Menu menu = new Menu();
    private Coach coach;
    Map<String, List<String>> coaches = new TreeMap<>();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runProgram() {
        outputView.printStart();
        List<String> coachNames = repeat(inputView::readCoachNames);
        List<String> disLikeFoods = new ArrayList<>();
        coach = writeDisLikeFoods(coachNames, disLikeFoods);
        menu.recommendCoach(coach);
        endProgram(menu);
    }

    private Coach writeDisLikeFoods(List<String> coachNames, List<String> disLikeFoods) {
        for (String coachName : coachNames) {
            try {
                disLikeFoods = inputView.readDislikeFoods(coachName);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                disLikeFoods = inputView.readDislikeFoods(coachName);
            }
            coaches.put(coachName, disLikeFoods);
        }
        coach = new Coach(coaches);
        return coach;
    }

    private void endProgram(Menu menu) {
        List<String> categoryResult = convertCategory(menu);
        List<List<String>> menuResult = convertRecommendedMenu(menu);
        outputView.printResult(categoryResult, menuResult);
        outputView.printEnd();
    }

    private List<String> convertCategory(Menu menu) {
        List<String> categoryResult = new ArrayList<>();
        categoryResult.add("카테고리");
        categoryResult.addAll(menu.getWeekCategories());
        return categoryResult;
    }

    private List<List<String>> convertRecommendedMenu(Menu menu) {
        List<List<String>> menuResult = new ArrayList<>();
        Map<String, List<String>> recommendMenus = menu.getRecommendedMenus() ;

        for (String coachName : recommendMenus.keySet()) {
            List<String> eachMenuResult = new ArrayList<>();
            eachMenuResult.add(coachName);
            eachMenuResult.addAll(recommendMenus.get(coachName));
            menuResult.add(eachMenuResult);
        }
        return menuResult;
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
