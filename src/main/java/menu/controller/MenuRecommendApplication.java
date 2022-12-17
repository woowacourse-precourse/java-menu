package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Weekly;
import menu.domain.WeeklyRecommendCategory;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static menu.constatnts.Constants.*;

public class MenuRecommendApplication {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> allMenu = new ArrayList<>();
    private List<Coach> allCoach = new ArrayList<>();

    public MenuRecommendApplication() {
        List<List<String>> allMenuPerCategory = Category.getAllMenu();
        for (List<String> menus : allMenuPerCategory) {
            allMenu.addAll(menus);
        }
    }

    public void start() {
        System.out.println(PRINT_START_MSG);
        List<String> coachNames = inputView.scanCoachNames();
        List<List<String>> hatesFood = scanHatesFood(coachNames);
        makeAllCoach(coachNames, hatesFood);
        WeeklyRecommendCategory weeklyCategory = makeWeeklyCategory(Weekly.getAllDaySize());
        makeAllCoachesMeals(weeklyCategory);
        outputView.printRecommendedMenu(allCoach, weeklyCategory);
    }

    private void makeAllCoachesMeals(WeeklyRecommendCategory weeklyCategory) {
        for (int categoryIdx : weeklyCategory.getCategoryIdxs()) {
            makeMeals(categoryIdx);
        }
    }

    public void makeMeals(int weeklyCategoryIdx) {
        List<String> menus = Category.getWantCategoryMenu(weeklyCategoryIdx);
        for (Coach coach : allCoach) {
            String menu = Randoms.shuffle(menus).get(0);
            while (coach.getMeals().contains(menu) || coach.getHates().contains(menu)) {
                menu = Randoms.shuffle(menus).get(0);
            }
            coach.addMeals(menu);
        }
    }


    private WeeklyRecommendCategory makeWeeklyCategory(int allDaySize) {
        List<Integer> weeklyCategory = new ArrayList<>();
        HashMap<Integer, Integer> categoryDuplicates = new HashMap<>();

        while (allDaySize-- > 0) {
            int categoryIdx = Randoms.pickNumberInRange(CATEGORY_START_NUM, CATEGORY_END_NUM);
            while (categoryDuplicates.getOrDefault(categoryIdx, 0) >= ABLE_ONE_WEEK_DUPLICATE_CATEGORY) {
                categoryIdx = Randoms.pickNumberInRange(CATEGORY_START_NUM, CATEGORY_END_NUM);
            }
            weeklyCategory.add(categoryIdx);
            categoryDuplicates.put(categoryIdx, categoryDuplicates.getOrDefault(categoryIdx, 0) + 1);
        }
        return new WeeklyRecommendCategory(weeklyCategory);
    }

    private void makeAllCoach(List<String> coachNames, List<List<String>> hatesFood) {
        for (int i = 0; i < coachNames.size(); i++) {
            allCoach.add(new Coach(coachNames.get(i), new HashSet<>(hatesFood.get(i))));
        }
    }


    private List<List<String>> scanHatesFood(List<String> coachNames) {
        List<List<String>> hatesFood = new ArrayList<>();
        for (String name : coachNames) {
            List<String> eachHatesFood = inputView.scanHatesFood(name);
            //있는 음식 인지 확인한다. 없는 음식인 경우 예외 처리
            checkValidFood(eachHatesFood);
            hatesFood.add(eachHatesFood);
        }
        return hatesFood;
    }

    private void checkValidFood(List<String> hatesFood) {
        for (String s : hatesFood) {
            if (!allMenu.contains(s)) {
                throw new IllegalArgumentException(ERROR_NONE_MENU);
            }
        }
    }
}
