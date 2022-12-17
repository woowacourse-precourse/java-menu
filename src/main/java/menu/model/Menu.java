package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Menu {
    JAPAN(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIA(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int code;
    private final String category;
    private final List<String> names;

    Menu(int code, String category, List<String> names) {
        this.code = code;
        this.category = category;
        this.names = names;
    }

    public static Menu getCodeToMenu(int code) {
        return Arrays.stream(Menu.values())
                .filter(e -> e.code == code)
                .findAny()
                .orElseGet(() -> getCodeToMenu(Randoms.pickNumberInRange(1, 5)));
    }

    public static String getCategoryToName(String category) {
        List<String> names = Arrays.stream(Menu.values())
                .filter(e -> e.category == category)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 카테고리가 존재하지 않습니다.")).names;
        return Randoms.shuffle(names).get(0);
    }

    public static List<String> selectCategory() {
        List<String> categorys = new ArrayList<>();
        while (categorys.size() < 5) {
            String category = getCodeToMenu(Randoms.pickNumberInRange(1, 5)).category;
            int count = Collections.frequency(categorys, category);
            if (count < 2) {
                categorys.add(category);
            }
        }
        return categorys;
    }

    public static List<String> selectMenu(List<String> categorys, List<String> cantEats) {
        List<String> menus = new ArrayList<>();

        categorys.stream().forEach(e -> {
            while (true) {
                String name = getCategoryToName(e);
                if (!menus.contains(name) && !cantEats.contains(name)) {
                    menus.add(name);
                    break;
                }
            }
        });

        return menus;
    }

}
