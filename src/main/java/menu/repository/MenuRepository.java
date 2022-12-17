package menu.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;

public class MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public MenuRepository() {
        init();
    }

    private void init() {
        String[] inputs = {"일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼",
                "한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음",
                "중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채",
                "아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜",
                "양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"};
        for (String input : inputs) {
            String[] split = input.split(": ");
            String category = split[0];
            String menusString = split[1];
            List<Menu> menus = Arrays.stream(menusString.split(", "))
                    .map(s -> new Menu(Category.of(category), s))
                    .collect(Collectors.toList());
            this.menus.addAll(menus);
        }
    }

    public Menu findByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isNameMatch(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 이름의 메뉴를 찾을 수 없습니다."));
    }

    public List<Menu> findByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.isCategoryMath(category))
                .collect(Collectors.toList());
    }
}
