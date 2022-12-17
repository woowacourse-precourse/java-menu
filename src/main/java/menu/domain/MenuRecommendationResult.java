package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendationResult {
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
        return count >= 2;
    }

    // 코치 1명의 한 요일 메뉴 추천 - 정해진 카테고리 내에서 추천
    public String menuRecommend(Day day, String coachName) {

        String shuffledMenu;
        while (true) {
            shuffledMenu = Categories.getShuffledMenu(categoriesResult.get(day));
            if (validateHateMenu(coachName, shuffledMenu) || !validateDuplicateMenu(coachName, shuffledMenu)) break;
        }
        return shuffledMenu;
    }

    private boolean validateHateMenu(String coachName, String shuffledMenu) {
        Map<String, List<String>> coachHateMenu = CoachRepository.getCoachHateMenu();
        if (coachHateMenu.get(coachName).contains(shuffledMenu)) {
            return false;
        }
        return true;
    }

    private boolean validateDuplicateMenu(String coachName, String shuffledMenu) {
        Map<Day, String> result = recommendationResult.get(coachName);
        return result.containsValue(shuffledMenu);
    }

    public void setRecommendationResult(String coachName, HashMap<Day, String> result) {
        recommendationResult.put(coachName, result);
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
