package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import menu.menu.NameOfMenu;

public enum Category {

    JAPANESE(1, "일식", NameOfMenu.getJapanese()),
    KOREAN(2, "한식", NameOfMenu.getKorean()),
    CHINESE(3, "중식", NameOfMenu.getChinese()),
    ASIAN(4, "아시안", NameOfMenu.getAsian()),
    WESTERN(5, "양식", NameOfMenu.getWestern());

    private final int order;
    private final String name;
    private final List<String> menus;

    Category(int order, String name, List<String> menus) {
        this.order = order;
        this.name = name;
        this.menus = menus;
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }

    public static Category of(int input) {
        return Arrays.stream(values())
                .filter(category -> category.order == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 카테고리 순서입니다. 입력값 : " + input));
    }

    public String createRandomMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
