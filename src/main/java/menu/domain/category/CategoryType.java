package menu.domain.category;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CategoryType {
    JAPANESE(1, "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼구수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식",
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안",
            List.of("팟타이", "카오 팟", "나시고랭", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식",
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int index;
    private final String name;
    private final List<String> menus;

    CategoryType(int index, String name, List<String> menus) {
        this.index = index;
        this.name = name;
        this.menus = menus;
    }

    public static final List<String> names =
            Collections.unmodifiableList(Stream.of(CategoryType.values())
                    .map(CategoryType::getName)
                    .collect(Collectors.toList()));


    private static final Map<String, CategoryType> categoryTypeByName =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(CategoryType::getName, Function.identity())));

    public String getName() {
        return name;
    }

    public static int getIndexByName(String korean) {
        return categoryTypeByName.get(korean)
                .index;
    }

    public static List<String> getMenusByName(String name) {
        return categoryTypeByName.get(name)
                .menus;
    }
}
