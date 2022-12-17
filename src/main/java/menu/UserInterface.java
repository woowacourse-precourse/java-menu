package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringJoiner;

public class UserInterface {
    public static String[] getCoachList() {
        try {
//            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            String[] coaches = Console.readLine().split(",");
            InputException.coachListCheck(coaches);
            InputException.coachNameCheck(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCoachList();
        }
    }

    public static String[] getHateMenus(String name) {
        try {
//            System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String[] hateMenus = Console.readLine().split(",");
            InputException.hateMenusNumCheck(hateMenus);
            return hateMenus;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getHateMenus(name);
        }
    }

    public static void notifyTotalResult(String[] categories, Coach[] coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(generateCategoryResult(categories));
        for (Coach coach : coaches) {
            System.out.println(generatePersonalResult(coach));
        }
        System.out.println("추천을 완료했습니다.");
    }

    private static String generateCategoryResult(String[] categories) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        sj.add("카테고리");
        for (String category: categories) {
            sj.add(category);
        }
        return sj.toString();
    }

    private static String generatePersonalResult(Coach coach) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        sj.add(coach.getName());
        for (String menu : coach.getAteMenus()) {
            sj.add(menu);
        }
        return sj.toString();
    }

}
