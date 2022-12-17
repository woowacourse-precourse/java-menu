package menu;

import java.util.Arrays;
import java.util.List;

public class Menus {
    private static final List<String> illsik = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    private static final List<String> hansik = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    private static final List<String> joongsik = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    private static final List<String> asian = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    private static final List<String> yangsik = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");

    public static boolean isContained(List<String> foods) {
        return isIllsik(foods) || isHansik(foods) || isJoongsik(foods) || isAsian(foods) || isYangsik(foods);
    }

    private static boolean isIllsik(List<String> foods) {
        for (String hateFood : foods) {
            if (!illsik.contains(hateFood)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isHansik(List<String> foods) {
        for (String hateFood : foods) {
            if (!hansik.contains(hateFood)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isJoongsik(List<String> foods) {
        for (String hateFood : foods) {
            if (!joongsik.contains(hateFood)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAsian(List<String> foods) {
        for (String hateFood : foods) {
            if (!asian.contains(hateFood)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isYangsik(List<String> foods) {
        for (String hateFood : foods) {
            if (!yangsik.contains(hateFood)) {
                return false;
            }
        }

        return true;
    }

}
