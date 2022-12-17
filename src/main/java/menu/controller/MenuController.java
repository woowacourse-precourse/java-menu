package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.util.MenuCategory;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static menu.domain.CategoryRepository.addToWeekCategory;
import static menu.domain.CategoryRepository.weekCategories;
import static menu.domain.CoachRepository.addCoach;
import static menu.domain.CoachRepository.coaches;
import static menu.util.MenuCategory.ASIAN;
import static menu.util.MenuCategory.CHINESE;
import static menu.util.MenuCategory.ITALIAN;
import static menu.util.MenuCategory.JAPANESE;
import static menu.util.MenuCategory.KOREAN;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MenuCategory, List<String>> categories = new EnumMap<>(MenuCategory.class);

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
        initCategory();
    }

    private void initCategory() {
        categories.put(JAPANESE, new ArrayList<>(
                Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")));
        categories.put(KOREAN, new ArrayList<>(
                Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")));
        categories.put(CHINESE, new ArrayList<>(
                Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")));
        categories.put(ASIAN, new ArrayList<>(
                Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")));
        categories.put(ITALIAN, new ArrayList<>(
                Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    }

    public void run() {
        outputView.printStartMessage();
        initCoach(inputView.readCoachName());
        initCannotEatMenuForEachCoach();
        decideRecommendMenu();
        outputView.printRecommendMenu();
        outputView.printFinishMessage();
    }

    private void initCoach(List<String> names) {
        for (String name : names) {
            addCoach(new Coach(name));
        }
    }

    private void initCannotEatMenuForEachCoach() {
        for (int i = 0; i < coaches().size(); i++) {
            coaches().get(i).initCannotEatMenu(inputView.readCannotEatMenu(i));
        }
    }

    private void decideRecommendMenu() {
        int day = 1;
        do {
            decideCategory();
            decideMenuForEachCoach(day);
            day++;
        } while (day != 6);
    }

    private void decideCategory() {
        try {
            MenuCategory category = MenuCategory.findCategory(Randoms.pickNumberInRange(1, 5));
            addToWeekCategory(category);
        } catch (IllegalArgumentException e) {
            decideCategory();
        }
    }

}
