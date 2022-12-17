package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String[] coachNames = inputCoachNames();
        addBannedMenu(coachNames);

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

        System.out.println("메뉴 추천 결과입니다.");
        printFormattedResultLine("구분", totalDay);
        printFormattedResultLine("카테고리", recommendedCategories);
        for (String coachName : coachNames) {
            printFormattedResultLine(coachName, recommendMenusByCoach.get(coachName));
        }
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private static void addBannedMenu(String[] coachNames) {
        for (String coachName : coachNames) {
            String[] bannedMenus = inputBannedMenu(coachName);
            System.out.println();
            if (bannedMenus == null) {
                continue;
            }
            for (String bannedMenu : bannedMenus) {
                MenuRecommendService.addBannedMenu(coachName, bannedMenu);
            }
        }
    }


    private static String[] inputCoachNames() {
        while (true) {
            System.out.println("점심 메뉴 추천을 시작합니다.\n");
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            try {
                String[] coachNames = getValidCoachNames();
                System.out.println();
                return coachNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] getValidCoachNames() throws IllegalArgumentException {
        String[] coachNames = Console.readLine().split(",");
        if (coachNames.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 입력해야 합니다.");
        }
        if (Stream.of(coachNames).anyMatch((coachName) -> coachName.length() < 2 || coachName.length() > 4)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자이어야 합니다.");
        }
        return coachNames;
    }
    private static String[] inputBannedMenu(String coachName) {
        while (true) {
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
            try {
                String[] bannedMenu = getValidBannedMenu();
                System.out.println();
                return bannedMenu;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] getValidBannedMenu() {
        String[] bannedMenu = Console.readLine().split(",");
        if (bannedMenu.length > 2) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 2개까지 입력 가능합니다.");
        }
        return bannedMenu;
    }

    private static void printFormattedResultLine(String group, List<String> contents) {
        StringJoiner result = new StringJoiner(" | ", "[ ", " ]");
        result.add(group);
        contents.forEach((content) -> result.add(content));
        System.out.println(result.toString());
    }
}
