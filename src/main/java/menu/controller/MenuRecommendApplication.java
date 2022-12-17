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
        //System.out.println(allMenu);
    }

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        List<String> coachNames = inputView.scanCoachNames();
        //System.out.println(coachNames);
        List<List<String>> hatesFood = scanHatesFood(coachNames);
        makeAllCoach(coachNames, hatesFood);
        WeeklyRecommendCategory weeklyCategory = makeWeeklyCategory(Weekly.getAllDaySize());
        //System.out.println(weeklyCategory.getCategoryIdxs());
        makeAllCoachesDiet(weeklyCategory);
        outputView.printRecommendedMenu(allCoach, weeklyCategory);
    }

    private void makeAllCoachesDiet(WeeklyRecommendCategory weeklyCategory) {
        for (int categoryIdx : weeklyCategory.getCategoryIdxs()) {
            makeMeals(categoryIdx);
        }
    }

    public void makeMeals(int weeklyCategoryIdx) {
        List<String> menus = Category.getWantCategoryMenu(weeklyCategoryIdx);
        for (Coach coach :allCoach) {
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
            int categoryIdx = Randoms.pickNumberInRange(1, 5);
            while (categoryDuplicates.getOrDefault(categoryIdx, 0) >= 2) {
                categoryIdx = Randoms.pickNumberInRange(1, 5);
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
            //있는 음식인지 확인 해야한다.
            checkValidFood(eachHatesFood);
            hatesFood.add(eachHatesFood);
        }
        return hatesFood;
    }

    private void checkValidFood(List<String> hatesFood) {
        for (String s : hatesFood) {
            if (!allMenu.contains(s)) {
                throw new IllegalArgumentException("[ERROR] 없는 메뉴 입니다.");
            }
        }
    }
}
