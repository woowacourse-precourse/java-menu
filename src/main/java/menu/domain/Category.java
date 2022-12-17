package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    일식("일식", 1, new ArrayList<String>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"))),
    한식("한식", 2, new ArrayList<String>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"))),
    중식("중식", 3, new ArrayList<String>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토", "달걀볶음", "고추잡채"))),
    아시안("아시안", 4, new ArrayList<String>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플", "볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"))),
    양식("양식", 5, new ArrayList<String>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    private final String category;
    private final int index;
    private final List<String> menu;

    Category(String category, int index, List<String> menu) {
        this.category = category;
        this.index = index;
        this.menu = menu;
    }

    public static String getFormat(List<Week> weeks) {
        return "[ 카테고리 | "
                + weeks.stream().map(week -> week.getCategory())
                .map(category -> category.category)
                .collect(Collectors.joining(" | "))
                + " ]";
    }

    public static Category get(int index) {
        return Arrays.stream(Category.values())
                .filter(menu -> menu.index == index)
                .findFirst()
                .get();
    }

    public static String recommendRandomMenu(Category category) {
        String menu = Randoms.shuffle(category.menu).get(0);
        return menu;
    }
}
