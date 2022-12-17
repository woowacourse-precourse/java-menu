package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu("규동",Category.JAPAN.getName()));
        menus.add(new Menu("우동",Category.JAPAN.getName()));
        menus.add(new Menu("미소시루",Category.JAPAN.getName()));
        menus.add(new Menu("스시",Category.JAPAN.getName()));
        menus.add(new Menu("가츠동",Category.JAPAN.getName()));
        menus.add(new Menu("오니기리",Category.JAPAN.getName()));
        menus.add(new Menu("하이라이스",Category.JAPAN.getName()));
        menus.add(new Menu("라멘",Category.JAPAN.getName()));
        menus.add(new Menu("오코노미야끼",Category.JAPAN.getName()));
        menus.add(new Menu("김밥",Category.KOREA.getName()));
        menus.add(new Menu("김치찌개",Category.KOREA.getName()));
        menus.add(new Menu("쌈밥",Category.KOREA.getName()));
        menus.add(new Menu("된장찌개",Category.KOREA.getName()));
        menus.add(new Menu("비빔밥",Category.KOREA.getName()));
        menus.add(new Menu("칼국수",Category.KOREA.getName()));
        menus.add(new Menu("불고기",Category.KOREA.getName()));
        menus.add(new Menu("떡볶이",Category.KOREA.getName()));
        menus.add(new Menu("제육볶음",Category.KOREA.getName()));
        menus.add(new Menu("깐풍기",Category.CHINA.getName()));
        menus.add(new Menu("볶음면",Category.CHINA.getName()));
        menus.add(new Menu("동파육",Category.CHINA.getName()));
        menus.add(new Menu("짜장면",Category.CHINA.getName()));
        menus.add(new Menu("짬뽕",Category.CHINA.getName()));
        menus.add(new Menu("마파두부",Category.CHINA.getName()));
        menus.add(new Menu("탕수육",Category.CHINA.getName()));
        menus.add(new Menu("토마토 달걀볶음",Category.CHINA.getName()));
        menus.add(new Menu("고추잡채",Category.CHINA.getName()));
        menus.add(new Menu("팟타이",Category.ASIAN.getName()));
        menus.add(new Menu("카오 팟",Category.ASIAN.getName()));
        menus.add(new Menu("나시고렝",Category.ASIAN.getName()));
        menus.add(new Menu("파인애플 볶음밥",Category.ASIAN.getName()));
        menus.add(new Menu("쌀국수",Category.ASIAN.getName()));
        menus.add(new Menu("똠얌꿍",Category.ASIAN.getName()));
        menus.add(new Menu("반미",Category.ASIAN.getName()));
        menus.add(new Menu("월남쌈",Category.ASIAN.getName()));
        menus.add(new Menu("분짜",Category.ASIAN.getName()));
        menus.add(new Menu("라자냐",Category.EAST.getName()));
        menus.add(new Menu("그라탱",Category.EAST.getName()));
        menus.add(new Menu("뇨끼",Category.EAST.getName()));
        menus.add(new Menu("끼슈",Category.EAST.getName()));
        menus.add(new Menu("프렌치 토스트",Category.EAST.getName()));
        menus.add(new Menu("바게트",Category.EAST.getName()));
        menus.add(new Menu("스파게티",Category.EAST.getName()));
        menus.add(new Menu("피자",Category.EAST.getName()));
        menus.add(new Menu("파니",Category.EAST.getName()));
    }

    public List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public Menu findByName(String menuName) {
        for (Menu menu : menus) {
            if (menu.isSame(menuName)) {
                return menu;
            }
        }
        return null;
    }

    public List<String> findCategoryMenu(String categoryName) {
        List<String> findMenu = new ArrayList<>();
        for (Menu menu : menus) {
            if (menu.getCategory().equals(categoryName)) {
                findMenu.add(menu.getName());
            }
        }
        return findMenu;
    }
}
