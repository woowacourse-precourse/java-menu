package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPAN(1, new ArrayList<>(), "일식"),
    KOREA(2, new ArrayList<>(), "한식"),
    CHINA(3, new ArrayList<>(), "중식"),
    ASIAN(4, new ArrayList<>(), "아시안"),
    WESTERN(5, new ArrayList<>(), "양식");

    private static final int PICK_MENU_INDEX = 0;
    private final int number;
    private final List<Menu> menus;
    private final String name;

    Category(int number, List<Menu> menus, String name) {
        this.number = number;
        this.menus = menus;
        this.name = name;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public int getNumber() {
        return number;
    }

    public String getRandomMenu() {
        return getRandomMenus().get(PICK_MENU_INDEX);
    }

    private List<String> getRandomMenus() {
        List<String> menuNames = menus.stream().map(menu -> {
            return menu.getName();
        }).collect(Collectors.toList());
        List<String> shuffledMenu = Randoms.shuffle(menuNames);
        return shuffledMenu;
    }

    public String getName() {
        return name;
    }

    public static Category findByNumber(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getNumber() == number).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 생성한 번호로 카테고리를 찾을 수 없습니다."));
    }
}

