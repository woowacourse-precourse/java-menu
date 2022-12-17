package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommend {
    private static final Category category = new Category();
    private static final Coach coach = new Coach();
    private static final Menu menu = new Menu();

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        List<String> categories = category.choose();
        List<String> names = getNames();
        Map<String, List<String>> hates = getHates(names);
        Map<String, List<String>> menus = menu.recommend(categories, names, hates);
        printResult(categories, names, menus);
    }

    private List<String> getNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        while (true) {
            try {
                List<String> names = coach.getNames();
                System.out.println();
                return names;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }

    private Map<String, List<String>> getHates(List<String> names) {
        Map<String, List<String>> hates = new HashMap<>();
        for (String name : names) {
            System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            hates.put(name, coach.getHates());
            System.out.println();
        }
        return hates;
    }

    private void printResult(List<String> categories, List<String> names, Map<String, List<String>> menus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printRow("카테고리", categories);
        for (String name : names) {
            printRow(name, menus.get(name));
        }
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printRow(String head, List<String> items) {
        System.out.println("[ " + head + " | " + String.join(" | ", items) + " ]");
    }
}
