package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private static List<String> categoires = List.of("", "일식", "한식", "중식", "아시안", "양식");
    private List<String> japan = List.of(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
    );
    private List<String> korea = List.of(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
    );
    private List<String> china = List.of(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
    );
    private List<String> asian = List.of(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
    );
    private List<String> europian = List.of(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
    );
    private Map<String, List<String>> categoryAll = new LinkedHashMap<>();

    public Category() {
        categoryAll.put("일식", japan);
        categoryAll.put("한식", korea);
        categoryAll.put("중식", china);
        categoryAll.put("아시안", asian);
        categoryAll.put("양식", europian);
    }

    public static String getRandomCategory() {
        return categoires.get(Randoms.pickNumberInRange(1, 5));
    }

    public String getRandomMenu(String category) {
        return Randoms.shuffle(categoryAll.get(category)).get(0);
    }
}
