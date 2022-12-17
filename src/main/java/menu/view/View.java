package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Category;
import menu.model.Coach;

import java.util.Arrays;
import java.util.List;

public class View {

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult(List<Coach> coaches, List<Category> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println(coaches.get(i));
        }
        System.out.println("추천을 완료했습니다.");
    }

    private static void printCategories(List<Category> categories) {
        String str = "[ 카테고리 | ";
        for (int i = 0; i < categories.size(); i++) {
            str += categories.get(i);
            if (i != categories.size() - 1)
                str += " | ";
        }
        str += " ]";

        System.out.println(str);
    }

    public static List<String> requestInputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = receiveInput();
        validateCoaches(input);

        return Arrays.asList(input.split(","));
    }

    public static List<String> requestUnwantedMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = receiveInput();
        validateMenus(input);
        return Arrays.asList(input.split(","));
    }

    private static String receiveInput() {
        String str = Console.readLine();
        return str;
    }


    private static void validateMenus(String input) {
        List<String> menus = Arrays.asList(input.split(","));

        if (menus.size() > 2)
            throw new IllegalArgumentException("못먹는 메뉴는 최대 2개까지 입니다.");

        if (input.contains(" "))
            throw new IllegalArgumentException("공백은 입력할 수 없슶니다.");
    }

    private static void validateCoaches(String input) {
        List<String> coaches = Arrays.asList(input.split(","));

        if (coaches.size() < 2 || coaches.size() > 5)
            throw new IllegalArgumentException("코치는 2명 이상, 5명 이하여야 합니다.");

        for (int i = 0; i < coaches.size(); i++) {
            String name = coaches.get(i);
            if (name.length() < 2 || name.length() > 4)
                throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }

        if (input.contains(" "))
            throw new IllegalArgumentException("공백은 입력할 수 없슶니다.");
    }
}
