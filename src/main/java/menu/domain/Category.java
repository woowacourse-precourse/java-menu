package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private final Map<String, List<String>> category = new HashMap<>();

    public Category() {
        init();
        addMenu();
    }

    public Map<String, List<String>> getCategory() {
        return category;
    }

    private void init() {
        category.put("일식", new ArrayList<>());
        category.put("한식", new ArrayList<>());
        category.put("중식", new ArrayList<>());
        category.put("아시안", new ArrayList<>());
        category.put("양식", new ArrayList<>());
    }

    private void addMenu() {
        for (String key : category.keySet()) {
            if (key.equals("일식")) {
                List<String> illsick = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
                category.put(key, illsick);
            }
            if (key.equals("한식")) {
                List<String> hansick = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
                category.put(key, hansick);
            }
            if (key.equals("중식")) {
                List<String> hansick = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
                category.put(key, hansick);
            }
            if (key.equals("아시안")) {
                List<String> hansick = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
                category.put(key, hansick);
            }
            if (key.equals("양식")) {
                List<String> hansick = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
                category.put(key, hansick);
            }
        }
    }

}
