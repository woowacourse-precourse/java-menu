package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final static int SIZE = 5;
    private final static String KOR = "한식";
    private final static String JPN = "일식";
    private final static String CHI = "중식";
    private final static String ASI = "아시안";
    private final static String WST = "양식";
    private final static String NOT_EXISTS_ERROR = "[ERROR] 존재하지 않는 카테고리입니다.";
    private final static List<String> korMenus = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이",
            "제육볶음");
    private final static List<String> jpnMenus = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘",
            "오코노미야끼");
    private final static List<String> chiMenus = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토",
            "달걀볶음", "고추잡채");
    private final static List<String> asiMenus = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미",
            "월남쌈", "분짜");
    private final static List<String> wstMenus = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자",
            "파니니");

    public Map<String, List<String>> generateMenus(List<String> categories, List<String> names,
                                                   Map<String, List<String>> hates) {
        Map<String, List<String>> menus = initRecommends(names);
        int idx = 0;
        while (idx < SIZE) {
            String category = categories.get(idx++);
            for (String name : names) {
                String menu = getMenu(category, menus.get(name), hates.get(name));
                menus.get(name).add(menu);
            }
        }
        return menus;
    }

    private Map<String, List<String>> initRecommends(List<String> names) {
        Map<String, List<String>> recommends = new HashMap<>();
        for (String name : names) {
            recommends.put(name, new ArrayList<>());
        }
        return recommends;
    }

    private String getMenu(String category, List<String> exists, List<String> hates) {
        while (true) {
            String menu = selectMenu(category);
            if (!exists.contains(menu) && !hates.contains(menu)) {
                return menu;
            }
        }
    }

    private String selectMenu(String category) {
        switch (category) {
            case KOR:
                return Randoms.shuffle(korMenus).get(0);
            case JPN:
                return Randoms.shuffle(jpnMenus).get(0);
            case CHI:
                return Randoms.shuffle(chiMenus).get(0);
            case ASI:
                return Randoms.shuffle(asiMenus).get(0);
            case WST:
                return Randoms.shuffle(wstMenus).get(0);
            default:
                throw new IllegalArgumentException(NOT_EXISTS_ERROR);
        }
    }
}