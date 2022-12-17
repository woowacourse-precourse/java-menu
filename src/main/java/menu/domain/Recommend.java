package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.repository.CoachRepository;

import java.util.ArrayList;
import java.util.List;

public class Recommend {
    private static final int CATEGORY_COUNT_MAX = 2;

    private List<Integer> randoms;
    private List<String> categories;

    public Recommend() {
        randoms = generateRandomNumbers();
        categories = generateCategories(randoms);
    }

    private List<String> generateCategories(List<Integer> randoms) {
        List<String> categories = new ArrayList<>();

        for (int i = 0; i < randoms.size(); i++) {
            int categoryNumber = randoms.get(i);
            categories.add(Category.getNameByNumber(categoryNumber));
        }
        return categories;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            randoms.add(randomNumber);
        }
        // 조건 체크
        int[] checkCategoryCount = new int[6];
        for (int categoryNumber : randoms) {
            checkCategoryCount[categoryNumber]++;
        }
        for (int i = 1; i <= 5; i++) {
            if (checkCategoryCount[i] > CATEGORY_COUNT_MAX) {
                generateRandomNumbers();
            }
        }

        return randoms;
    }


    public List<String> generateRecommendMenus(Coach coach) {
        List<String> recommendMenus = new ArrayList<>();

        List<String> forbiddenFoods = coach.getForbiddenFoods();

        for (int i = 0; i < categories.size(); i++) {
            int categoryNumber = randoms.get(i);
            List<String> menus = Category.getMenus(categoryNumber);
            String menu = Randoms.shuffle(menus).get(0);
            recommendMenus.add(menu);
        }

        return recommendMenus;
    }

    private boolean isDuplicatedMenu(List<String> recommendMenus) {
        for(String menu : recommendMenus) {
            if(recommendMenus.contains(menu)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getCategories() {
        return categories;
    }
}
