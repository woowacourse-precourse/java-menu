package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.enums.Categories.*;

public class RecommendMenuServiceImpl implements RecommendMenuService {
    private final Map<String, List<String>> menus;

    public RecommendMenuServiceImpl() {
        this.menus = new HashMap<>();
        settingMenu();
    }

    private void settingMenu() {
        addJapan();
        addKorea();
        addChina();
        addAsian();
        addWestern();
    }

    public void recommend(List<Coach> coaches, List<String> categories) {
        categories.forEach(it -> selectMenuForCoach(coaches, it));
    }

    private void selectMenuForCoach(List<Coach> coaches, String category) {
        for (Coach coach : coaches) {
            String menu = getRandomMenu(category);
            addMenuToCoach(coach, menu);
        }
    }

    private void addMenuToCoach(Coach coach, String menu) {
        while (true) {
            if (coach.isNotRefuseMenu(menu) && coach.isFirstRecommendMenu(menu)) {
                coach.addRecommendMenu(menu);
                break;
            }
        }
    }

    private String getRandomMenu(String category) {
        return Randoms.shuffle(menus.get(category)).get(0);
    }

    private void addWestern() {
        menus.put(WESTERN.getName(), List.of(
                "라자냐", "그라탱",
                "뇨끼", "끼슈",
                "프렌치 토스트", "바게트",
                "스파게티", "피자",
                "파니니"));
    }

    private void addAsian() {
        menus.put(ASIAN.getName(), List.of(
                "팟타이", "카오 팟",
                "나시고렝", "파인애플 볶음밥",
                "쌀국수", "똠얌꿍",
                "반미", "월남쌈",
                "분짜"));
    }

    private void addChina() {
        menus.put(CHINA.getName(), List.of(
                "깐풍기", "볶음면",
                "동파육", "짜장면",
                "짬뽕", "마파두부",
                "탕수육", "토마토 달걀볶음",
                "고추잡채"));
    }

    private void addJapan() {
        menus.put(JAPAN.getName(), List.of(
                "규동", "우동",
                "미소시루", "스시",
                "가츠동", "오니기리",
                "하이라이스", "라멘",
                "오코노미야끼"));
    }

    private void addKorea() {
        menus.put(KOREA.getName(), List.of(
                "김밥", "김치찌개",
                "쌈밥", "된장찌개",
                "비빔밥", "칼국수",
                "불고기", "떡볶이",
                "제육볶음"));
    }
}
