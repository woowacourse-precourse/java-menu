package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.client.MenuClient;
import menu.di.MenuUseCase;
import menu.di.MenuUseCaseImpl;
import menu.domain.Picker;
import menu.domain.RandomPicker;

public class Application {

    public static void main(String[] args) {
        MenuClient menuClient = new MenuClient(getMenuUseCase());
        menuClient.run();
    }

    private static MenuUseCase getMenuUseCase() {
        Map<String, List<String>> menus = loadMenus();
        Picker picker = new RandomPicker();
        return new MenuUseCaseImpl(menus, picker);
    }

    private static Map<String, List<String>> loadMenus() {
        Map<String, List<String>> menus = new HashMap<>();
        menus.put("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menus.put("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menus.put("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menus.put("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menus.put("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        return menus;
    }


}
