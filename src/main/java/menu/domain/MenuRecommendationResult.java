package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendationResult {
    //    private Map<Day, Map<String, String>> recommendationResult = new HashMap();
    private Map<String, Map<Day, String>> recommendationResult = new HashMap();
    private Map<Day, Categories> categoriesResult = new HashMap<>();

    public void selectDayCategory(Day day) {
        numberGenerator randomNumberGenerator = new RandomNumberGenerator();

        Categories category;
        while (true) {
            int index = randomNumberGenerator.generate();
            category = Categories.getCategoryBYIndex(index);

            if (!validateDuplicateCategory(category)) break;
        }
        categoriesResult.put(day, category);
    }

    private boolean validateDuplicateCategory(Categories category) {
        int count = 0;
        for (Categories categories : categoriesResult.values()) {
            if (categories.equals(category)) count++;
        }
        return count > 2;
    }

    public void menuRecommend(Day day, String coachName) {
        numberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int index = randomNumberGenerator.generate();
        Categories category = Categories.getCategoryBYIndex(index);

        String shuffledMenu;
        while (true) {
            shuffledMenu = Categories.getShuffledMenu(index);
            if (validateHateMenu(coachName, shuffledMenu)) break;
        }

        HashMap<Day, String> result = new HashMap<>();
        result.put(day, shuffledMenu);

        recommendationResult.put(coachName, result);
    }

    private boolean validateHateMenu(String coachName, String shuffledMenu) {
        Map<String, List<String>> coachHateMenu = CoachRepository.getCoachHateMenu();
        if (coachHateMenu.get(coachName).contains(shuffledMenu)) {
            return false;
        }
        return true;
    }

    public Map<String, Map<Day, String>> getRecommendationResult() {
        return recommendationResult;
    }

    public Map<Day, Categories> getCategoriesResult() {
        return categoriesResult;
    }

    @Override
    public String toString() {
        return "MenuRecommendationResult{" +
                "recommendationResult=" + recommendationResult +
                '}' +
                "MenuRecommendationResult{" +
                "categoriesResult=" + categoriesResult +
                '}'
                ;
    }
}
