package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String[] coachNames = Console.readLine().split(",");
        System.out.println();
        for (String coachName : coachNames) {
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
            String bannedMenus = Console.readLine().strip();
            System.out.println();
            if (bannedMenus.length() == 0) {
                continue;
            }
            for (String bannedMenu : bannedMenus.split(",")) {
                MenuRecommendService.addBannedMenu(coachName, bannedMenu);
            }
        }

        List<String> totalDay = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
        List<String> recommendedCategories = new ArrayList<>();
        for (int i = 0; i < totalDay.size(); i++) {
            recommendedCategories.add(CategoryRecommendService.recommendCategory());
        }
        Map<String, List<String>> recommendMenusByCoach = new HashMap<>();
        for (String coachName : coachNames) {
            recommendMenusByCoach.put(coachName, new ArrayList<>());
            for (int i = 0; i < totalDay.size(); i++) {
                recommendMenusByCoach.get(coachName)
                        .add(MenuRecommendService.recommendMenu(coachName, recommendedCategories.get(i)));
            }
        }
    }
}
