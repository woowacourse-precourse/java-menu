package menu.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Category {
    JAPAN(1, "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),

    KOREA(2, "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),

    CHINA(3, "중식",
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),

    ASIAN(4, "아시안",
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),

    WESTERN(5, "양식",
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    //    private final static int WEEK
    private int code;
    private String categoryName;
    private List<String> menuList;

    Category(int code, String categoryName, List<String> menuList) {
        this.code = code;
        this.categoryName = categoryName;
        this.menuList = new ArrayList<>(menuList);
    }

    public static List<Category> getCategoryOfWeekList() {
        Category[] categories = values();
        Map<Category, Integer> categoryCnt = initCategoryCnt(categories);
        List<Category> dailyList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Category randomCategory = findRandomCategory(categories, categoryCnt);
            dailyList.add(randomCategory);
        }
        return dailyList;
    }

    private static Category findRandomCategory(Category[] categories, Map<Category, Integer> categoryCnt) {
        Category randomCategory;
        do {
            randomCategory = categories[Randoms.pickNumberInRange(1, 5) - 1];
        } while (!isAvailableCategory(categoryCnt, randomCategory));
        return randomCategory;
    }

    private static boolean isAvailableCategory(Map<Category, Integer> categoryCnt, Category randomCategory) {
        if (categoryCnt.get(randomCategory) + 1 <= 2) {
            categoryCnt.put(randomCategory, categoryCnt.get(randomCategory) + 1);
            return true;
        }
        return false;
    }

    private static Map<Category, Integer> initCategoryCnt(Category[] categories) {
        Map<Category, Integer> categoryCnt = new HashMap<>();
        for (Category category : categories) {
            categoryCnt.put(category, 0);
        }
        return categoryCnt;
    }

    public List<String> getMenuList() {
        return this.menuList;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
