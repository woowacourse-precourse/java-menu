package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
 */
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

    public Menu getRandomMenu() {
        return getRandomMenus().get(PICK_MENU_INDEX);
    }

    private List<Menu> getRandomMenus() {
        return Randoms.shuffle(menus);
    }

    public String getName() {
        return name;
    }

    public static Category findByName(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getName().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 이름으로 카테고리를 찾을 수 없습니다."));
    }

    public static Category findByNumber(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getNumber() == number).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 생성한 번호로 카테고리를 찾을 수 없습니다."));
    }
}

