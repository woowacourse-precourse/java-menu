package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;
import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static final List<String> TOTAL_DAY = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
    public static final String INPUT_NAME_MESSAGE = "점심 메뉴 추천을 시작합니다.\n코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String MENU_RESULT_START = "메뉴 추천 결과입니다.";
    public static final String MENU_RESULT_END = "추천을 완료했습니다.";

    public static void main(String[] args) {
        String[] coachNames = inputCoachNames();
        addBannedMenu(coachNames);
        List<String> recommendedCategories = new ArrayList<>();
        Map<String, List<String>> recommendMenusByCoach = recommendMenu(recommendedCategories, coachNames);
        showResult(coachNames, recommendedCategories, recommendMenusByCoach);
    }


    private static void addBannedMenu(String[] coachNames) {
        for (String coachName : coachNames) {
            String[] bannedMenus = inputBannedMenu(coachName);
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
            System.out.println(INPUT_NAME_MESSAGE);
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
        String bannedSentence = Console.readLine();
        if (bannedSentence.length() == 0) { // 공백 입력시 null리턴
            return null;
        }
        String[] bannedMenu = bannedSentence.split(",");
        if (bannedMenu.length > 2) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 2개까지 입력 가능합니다.");
        }
        if (Stream.of(bannedMenu).anyMatch((menu) -> !MenuRecommendService.isValidMenu(menu))) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴가 있습니다.");
        }
        return bannedMenu;
    }

    private static Map<String, List<String>> recommendMenu(List<String> recommendedCategories, String[] coachNames) {
        for (int i = 0; i < TOTAL_DAY.size(); i++) {
            recommendedCategories.add(CategoryRecommendService.recommendCategory());
        }
        Map<String, List<String>> recommendMenusByCoach = new HashMap<>();
        for (String coachName : coachNames) {
            recommendMenusByCoach.put(coachName, new ArrayList<>());
            for (int i = 0; i < TOTAL_DAY.size(); i++) {
                recommendMenusByCoach.get(coachName)
                        .add(MenuRecommendService.recommendMenu(coachName, recommendedCategories.get(i)));
            }
        }
        return recommendMenusByCoach;
    }

    private static void showResult(String[] coachNames, List<String> recommendedCategories, Map<String, List<String>> recommendMenusByCoach) {
        System.out.println(MENU_RESULT_START);
        printFormattedResultLine("구분", TOTAL_DAY);
        printFormattedResultLine("카테고리", recommendedCategories);
        for (String coachName : coachNames) {
            printFormattedResultLine(coachName, recommendMenusByCoach.get(coachName));
        }
        System.out.println();
        System.out.println(MENU_RESULT_END);
    }

    private static void printFormattedResultLine(String group, List<String> contents) {
        StringJoiner result = new StringJoiner(" | ", "[ ", " ]");
        result.add(group);
        contents.forEach((content) -> result.add(content));
        System.out.println(result.toString());
    }
}
