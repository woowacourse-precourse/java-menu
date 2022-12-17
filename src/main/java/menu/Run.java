package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import menu.View.InputView;
import menu.View.OutputView;

public class Run {
    private List<Coach> coaches = new ArrayList<>();
    private List<String> coachesName = new ArrayList<>();
    private List<String> choosedCategories = new ArrayList<>();
    private Map<String, List> menu;


    public Run() {
        coachesName = getCoachesName();
        coaches = makeCoaches(coachesName);
        menu = menuToMap();
        while(choosedCategories.size() < 5) {
            chooseMenu();
        }
        new OutputView().printResult(choosedCategories, coaches);
    }

    private List<String> getCoachesName() {
        while(true) {
            try {
                return new InputView().getCoachesName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getHateFood(String name) {
        while(true) {
            try {
                return new InputView().getHateFood(name);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Coach> makeCoaches(List<String> coachesName) {
        for (int i = 0; i < coachesName.size(); i++) {
            String name = coachesName.get(i);
            List<String> hateFood = getHateFood(name);
            Coach coach = new Coach(name, hateFood);
            coaches.add(coach);
        }
        return coaches;
    }

    private void chooseMenu() {
        List<String> categories = new ArrayList<>(List.of("", "일식", "한식", "중식", "아시안", "양식"));
        String category = categories.get(Randoms.pickNumberInRange(1, 5));
        if (isOkCategory(choosedCategories, category)) {
            choosedCategories.add(category);
        }
        for (int i = 0; i < coaches.size(); i++) {
            coaches.get(i).selectMenu(menu.get(category));
        }
    }

    private boolean isOkCategory(List<String> choosed, String category) {
        int cnt = 0;
        for (int i = 0; i < choosed.size(); i++) {
            if (choosed.get(i).equals(category)) {
                cnt++;
            }
        }
        return cnt <= 2;
    }

    private Map<String, List> menuToMap () {
        Map<String, List> menuMap = new HashMap<>();
        menuMap.put("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menuMap.put("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menuMap.put("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menuMap.put("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menuMap.put("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        return menuMap;
    }
}
