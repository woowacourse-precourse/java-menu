package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;
import menu.vo.Coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        foods = menusToList(foodCategory.menus());
    }

    // 메뉴 문자열을 쪼개 문자열 리스트로 변환
    private List<String> menusToList(String menus) {
        return Arrays.asList(menus.split(",")).stream()
                .map(v -> v.trim())
                .collect(Collectors.toList());
    }

}
