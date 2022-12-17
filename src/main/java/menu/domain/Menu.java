package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.dto.CoachMenu;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;
import menu.vo.Coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final FoodCategory foodCategory;
    private List<String> foods;

    public Menu(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
        initFoodsByCategory(foodCategory);
    }

    // 코치의 정보를 넣으면 카테고리 안에서 메뉴를 선택해준다.
    public List<CoachWeekMenu> chooseShuffleMenu(List<CoachWeekMenu> coaches) {
        String menu;
        for (CoachWeekMenu coachWeekMenu : coaches) {
            menu = shuffleMenu(coachWeekMenu.getCoach(),coachWeekMenu.getEatMenus());
            coachWeekMenu.getEatMenus().add(menu);
        }
        return coaches;
    }

    //// private

    // 예외 사항을 판단하여 최종 메뉴를 얻는다.
    private String shuffleMenu(Coach coach, List<String> eatMenus){
        String menu;
        while (true) {
            menu = Randoms.shuffle(foods).get(0);
            if (checkNotEatMenu(coach,menu) && checkAlreadyChoose(menu,eatMenus)) {
                return menu;
            }
        }
    }

    // 먹을 수 있는 음식인지 판단. 먹을 수 있으면 true / 없으면 false
    private boolean checkNotEatMenu(Coach coach, String menu) {
        for (String notEatMenu : coach.getMenu()) {
            if (menu.equals(notEatMenu)) {
                return false;
            }
        }
        return true;
    }

    // 이미 코치가 한 주에 음식인지 판단. 선택 가능시 true / 아닐 시 false
    private boolean checkAlreadyChoose(String menu, List<String> eatMenus) {
        for (String chooseMenu : eatMenus) {
            if (menu.equals(chooseMenu)) {
                return false;
            }
        }
        return true;
    }

    // 카테고리에 따라 foods 초기화
    private void initFoodsByCategory(FoodCategory foodCategory) {
        if (foodCategory.equals(FoodCategory.KOR)) {
            foods = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        } else if (foodCategory.equals(FoodCategory.JAP)) {
            foods = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        } else if (foodCategory.equals(FoodCategory.CHI)) {
            foods = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        } else if (foodCategory.equals(FoodCategory.ASI)) {
            foods = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        } else if (foodCategory.equals(FoodCategory.WES)) {
            foods = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
        }
    }
}
