package menu;

import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.*;

public class Application {
    public static final List<String> TOTAL_DAY = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");

    public static void main(String[] args) {
        String[] coachNames = InputView.inputCoachNames();
        addBannedMenu(coachNames);
        List<String> recommendedCategories = getRecommendedCategory();
        Map<String, List<String>> recommendMenusByCoach = recommendMenu(recommendedCategories, coachNames);
        OutputView.showResult(coachNames, TOTAL_DAY, recommendedCategories, recommendMenusByCoach);
    }

    private static void addBannedMenu(String[] coachNames) {
        for (String coachName : coachNames) {
            String[] bannedMenus = InputView.inputBannedMenu(coachName);
            if (bannedMenus == null) {
                continue;
            }
            for (String bannedMenu : bannedMenus) {
                MenuRecommendService.addBannedMenu(coachName, bannedMenu);
            }
        }
    }

    public static List<String> getRecommendedCategory() {
        List<String> recommendedCategories = new ArrayList<>();
        for (int i = 0; i < TOTAL_DAY.size(); i++) {
            recommendedCategories.add(CategoryRecommendService.recommendCategory());
        }
        return recommendedCategories;
    }

    private static Map<String, List<String>> recommendMenu(List<String> recommendedCategories, String[] coachNames) {
        Map<String, List<String>> recommendMenusByCoach = new HashMap<>();
        for (String coachName : coachNames) {
            recommendMenusByCoach.put(coachName, new ArrayList<>());
        }

        for (int i = 0; i < TOTAL_DAY.size(); i++) {
            for (String coachName : coachNames) {
                recommendMenusByCoach.get(coachName)
                        .add(MenuRecommendService.recommendMenu(coachName, recommendedCategories.get(i)));
            }
        }
        return recommendMenusByCoach;
    }
}
