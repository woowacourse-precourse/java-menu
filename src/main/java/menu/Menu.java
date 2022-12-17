package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final static List<String> korMenus = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이",
            "제육볶음");
    private final static List<String> jpnMenus = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘",
            "오코노미야끼");
    private final static List<String> chiMenus = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토",
            "달걀볶음", "고추잡채");
    private final static List<String> asiMenus = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미",
            "월남쌈", "분짜");
    private final static List<String> wstMenus = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자",
            "파니니");

    public List<String> recommend(List<String> categories, List<String> hates) {
        List<String> recommends = new ArrayList<>();
        int idx = 0;
        while (idx < 5) {
            String category = categories.get(idx);
            String menu = selectMenu(category);
            if (!recommends.contains(menu) && !hates.contains(menu)) {
                recommends.add(menu);
                idx++;
            }
        }
        return recommends;
    }

    private String selectMenu(String category) {
        switch (category) {
            case "한식":
                return korMenus.get(Randoms.pickNumberInRange(0, 8));
            case "일식":
                return jpnMenus.get(Randoms.pickNumberInRange(0, 8));
            case "중식":
                return chiMenus.get(Randoms.pickNumberInRange(0, 8));
            case "아시안":
                return asiMenus.get(Randoms.pickNumberInRange(0, 8));
            case "양식":
                return wstMenus.get(Randoms.pickNumberInRange(0, 8));
            default:
                throw new IllegalArgumentException();
        }
    }
}
