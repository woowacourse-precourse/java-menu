package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Menu {

    public static final Map<Integer, List<String>> MENU = new HashMap<>();

    static {
        List<String> menu = new ArrayList<>();

        menu.add("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        menu.add("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        menu.add("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        menu.add("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        menu.add("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

        for (int i = 0; i < menu.size(); i++) {
            StringTokenizer st = new StringTokenizer(menu.get(i), ",");
            List<String> m = new ArrayList<>();

            while (st.hasMoreTokens()) {
                MENU.computeIfAbsent(i + 1, k -> new ArrayList<>());
                MENU.get(i + 1).add(st.nextToken());
            }
        }
    }
}
