package menu.domain;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    JAPAN(Category.JAPANESE, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(Category.KOREAN, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(Category.CHINESE, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(Category.ASIAN, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(Category.WESTERN, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final Category category;
    private final List<String> menus;

    Menu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static boolean isExist(String menu) {
        return Arrays.stream(Menu.values())
                .map(Menu::getMenus)
                .anyMatch(menus -> menus.contains(menu));
    }

    public static String getRandomMenuByCategory(Category targetCategory) {
        List<String> menuNames = Arrays.stream(Menu.values())
                .filter(menu -> menu.category == targetCategory)
                .map(Menu::getMenus)
                .flatMap(menus -> menus.stream())
                .collect(Collectors.toList());

        return shuffle(menuNames).get(0);
    }
}
