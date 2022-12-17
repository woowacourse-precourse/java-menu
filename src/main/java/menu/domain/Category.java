package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private final List<String> category = new ArrayList<>();
    private final Map<String, List<String>> menus = new HashMap<>();

    public Category() {
        init();
        addMenu();
    }

    public Map<String, List<String>> getMenus() {
        return menus;
    }

    public List<String> getCategory() {
        return category;
    }

    public String get(int index) {
        return category.get(index - 1);
    }

    private void init() {
        category.add("일식");
        category.add("한식");
        category.add("중식");
        category.add("아시안");
        category.add("양식");
        for (String title : category) {
            menus.put(title, new ArrayList<>());
        }
    }

    private void addMenu() {
        for (String key : menus.keySet()) {
            if (key.equals("일식")) {
                List<String> illsick = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
                menus.put(key, illsick);
            }
            if (key.equals("한식")) {
                List<String> hansick = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
                menus.put(key, hansick);
            }
            if (key.equals("중식")) {
                List<String> hansick = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
                menus.put(key, hansick);
            }
            if (key.equals("아시안")) {
                List<String> hansick = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
                menus.put(key, hansick);
            }
            if (key.equals("양식")) {
                List<String> hansick = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
                menus.put(key, hansick);
            }
        }
    }

}
