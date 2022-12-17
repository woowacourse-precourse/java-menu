package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {
    JAPAN("일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토", "달걀볶음", "고추잡채")),
    ASIAN("아시안", Arrays.asList("팟타이", "카오", "팟", "나시고렝", "파인애플", "볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WEST("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치", "토스트", "바게트", "스파게티", "피자", "파니니"));

    private static List<String> categories = new ArrayList<>(Arrays.asList("", "일식", "한식", "중식", "아시안", "양식"));
    private String kind;
    private List<String> menu;

    Category(String kind, List<String> menu) {
        this.kind = kind;
        this.menu = menu;
    }

    public static String recommendKind() {
        return categories.get(Randoms.pickNumberInRange(1, 5));
    }

    public static String recommendFood(String kind) {
        Category category = valueOfKind(kind);
        List<String> menu = category.getMenu();
        return Randoms.shuffle(menu).get(0);
    }

    private static final Map<String, Category> BY_KIND =
            Stream.of(values()).collect(Collectors.toMap(Category::getKind, Function.identity()));

    public static Category valueOfKind(String kind) {
        return BY_KIND.get(kind);
    }

    public static boolean isInMenu(String food) {
        return Arrays.stream(values())
                .anyMatch(value -> value.getMenu().contains(food));
    }

    public String getKind() {
        return kind;
    }

    public List<String> getMenu() {
        return menu;
    }
}
