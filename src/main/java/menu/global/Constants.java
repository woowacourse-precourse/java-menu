package menu.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class Constants {

    public static final Map<Integer, String> MENU_NAME = Map.of(1, "일식",
                                                                2, "한식",
                                                                3, "중식",
                                                                4, "아시안",
                                                                5, "양식");

    public static final List<String> DAY = List.of("구분", "월요일", "화요일",
                                                   "수요일", "목요일", "금요일");

    public static final Map<String, List<String>> MENU = new HashMap<>();

    static {
        List<String> menu = List.of("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼",
                                    "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음",
                                    "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채",
                                    "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜",
                                    "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

        for (int i = 0; i < menu.size(); i++) {
            StringTokenizer st = new StringTokenizer(menu.get(i), ",");

            while (st.hasMoreTokens()) {
                MENU.computeIfAbsent(MENU_NAME.get(i + 1), k -> new ArrayList<>());
                MENU.get(MENU_NAME.get(i + 1)).add(st.nextToken());
            }
        }
    }
}
