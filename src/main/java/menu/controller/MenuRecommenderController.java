package menu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRecommender;
import menu.domain.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommenderController {

    public void run() {
        MenuRecommender menuRecommender = initMenus();
        List<Coach> coaches = initCoaches();
        inputBannedMenusOfCoaches(coaches, menuRecommender);
    }

    private void inputBannedMenusOfCoaches(List<Coach> coaches, MenuRecommender menuRecommender) {
        for (Coach coach : coaches) {
            InputView.inputBannedMenus(coach.getName(), menuRecommender);
        }
    }

    private List<Coach> initCoaches() {
        OutputView.printGuideOfAppStart();
        return InputView.inputCoaches();
    }

    private MenuRecommender initMenus() {
        Map<Category, Menus> menu = new HashMap<>();
        String[] japanMenus = {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"};
        String[] koreaMenus = {"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
        String[] chinaMenus = {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
        String[] asianMenus = {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
        String[] westernMenus = {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"};

        postMenus(menu, Category.JAPAN, japanMenus);
        postMenus(menu, Category.KOREA, koreaMenus);
        postMenus(menu, Category.CHINA, chinaMenus);
        postMenus(menu, Category.ASIAN, asianMenus);
        postMenus(menu, Category.WESTERN, westernMenus);
        return new MenuRecommender(menu);
    }

    private void postMenus(Map<Category, Menus> menu, Category category, String[] menuNames) {
        List<Menu> menus = Arrays.stream(menuNames)
            .map(menuName -> new Menu(category, menuName))
            .collect(Collectors.toList());
        menu.put(category, new Menus(category, menus));
    }
}
