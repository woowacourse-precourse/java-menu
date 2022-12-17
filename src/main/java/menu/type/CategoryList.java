package menu.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoryList {

    일식(1, Arrays.asList("규동","우동","미소시루","스시","가츠동","오니기리","하이라이스","라멘","오코노모야키")),

    한식(2, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),

    중식(3, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),

    아시안(4, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),

    양식(5, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int code;
    private final List<String> menus;

    CategoryList(int code, List<String> menus) {
        this.code = code;
        this.menus = menus;
    }

    public int getCode() {
        return code;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static List<String> getMenusByCategory(String category) {
        for (CategoryList categories : CategoryList.values()) {
            if (categories.toString().equals(category)) {
                return categories.getMenus();

            }
        }
        throw new IllegalArgumentException("해당하는 카테고리가 없습니다.");
    }

    public static List<String> getAllMenus() {
        List<String> menus = new ArrayList<>();
        for (CategoryList category : CategoryList.values()) {
            menus.addAll(category.getMenus());
        }
        return menus;
    }
}
