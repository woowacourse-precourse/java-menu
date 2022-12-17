package menu;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.MenuRecommender;
import menu.ui.input.Input;
import menu.ui.output.Output;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static Output output = new Output();
    private static Input input = new Input();

    public static void main(String[] args) {
        output.notifyInitializing();
        List<String> coachNames = input.receiveCoaches();
        List<List<String>> bannedMenus = input.receiveUnavailableMenu(coachNames);
        List<Coach> coachList = createCoachList(coachNames, bannedMenus);
        MenuRecommender menuRecommender = new MenuRecommender(coachList);
        List<List<String>> recommendationResult = menuRecommender.getRecommendationResult();
        List<Category> categories = menuRecommender.getCategoryHistory();
        output.printResult(categories, recommendationResult);
        output.notifyEnding();
    }

    private static List<Coach> createCoachList(List<String> coaches, List<List<String>> unavailableMenus) {
        List<Coach> result = new ArrayList<>();

        for (int coachIndex = 0; coachIndex < coaches.size(); coachIndex++) {
            String name = coaches.get(coachIndex);
            List<String> banedMenu = unavailableMenus.get(coachIndex);

            result.add(new Coach(name, banedMenu));
        }

        return result;
    }
}
