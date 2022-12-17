package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public MenuRepository() {
        setDefaultValue();
    }

    private void setDefaultValue() {
        setKoreanMenu();
        setJapaneseMenu();
        setChineseMenu();
        setAsianMenu();
        setFrenchMenu();
    }

    private void setJapaneseMenu() {
        menus.addAll(List.of(
                Menu.of("규동", MenuCategory.JAPANESE),
                Menu.of("우동", MenuCategory.JAPANESE),
                Menu.of("미소시루", MenuCategory.JAPANESE),
                Menu.of("스시", MenuCategory.JAPANESE),
                Menu.of("가츠동", MenuCategory.JAPANESE),
                Menu.of("오니기리", MenuCategory.JAPANESE),
                Menu.of("하이라이스", MenuCategory.JAPANESE),
                Menu.of("라멘", MenuCategory.JAPANESE),
                Menu.of("오코노미야끼", MenuCategory.JAPANESE)
        ));
    }

    private void setKoreanMenu() {
        menus.addAll(List.of(
                Menu.of("김밥", MenuCategory.KOREAN),
                Menu.of("김치찌개", MenuCategory.KOREAN),
                Menu.of("쌈밥", MenuCategory.KOREAN),
                Menu.of("된장찌개", MenuCategory.KOREAN),
                Menu.of("비빔밥", MenuCategory.KOREAN),
                Menu.of("칼국수", MenuCategory.KOREAN),
                Menu.of("불고기", MenuCategory.KOREAN),
                Menu.of("떡볶이", MenuCategory.KOREAN),
                Menu.of("제육볶음", MenuCategory.KOREAN)
        ));
    }

    private void setChineseMenu() {
        menus.addAll(List.of(
                Menu.of("깐풍기", MenuCategory.CHINESE),
                Menu.of("볶음면", MenuCategory.CHINESE),
                Menu.of("동파육", MenuCategory.CHINESE),
                Menu.of("짜장면", MenuCategory.CHINESE),
                Menu.of("짬뽕", MenuCategory.CHINESE),
                Menu.of("마파두부", MenuCategory.CHINESE),
                Menu.of("탕수육", MenuCategory.CHINESE),
                Menu.of("토마토 달걀볶음", MenuCategory.CHINESE),
                Menu.of("고추잡채", MenuCategory.CHINESE)
        ));
    }

    private void setAsianMenu() {
        menus.addAll(List.of(
                Menu.of("팟타이", MenuCategory.ASIAN),
                Menu.of("카오 팟", MenuCategory.ASIAN),
                Menu.of("나시고렝", MenuCategory.ASIAN),
                Menu.of("파인애플 볶음밥", MenuCategory.ASIAN),
                Menu.of("쌀국수", MenuCategory.ASIAN),
                Menu.of("똠얌꿍", MenuCategory.ASIAN),
                Menu.of("반미", MenuCategory.ASIAN),
                Menu.of("월남쌈", MenuCategory.ASIAN),
                Menu.of("분짜", MenuCategory.ASIAN)
        ));
    }

    private void setFrenchMenu() {
        menus.addAll(List.of(
                Menu.of("라자냐", MenuCategory.FRENCH),
                Menu.of("그라탱", MenuCategory.FRENCH),
                Menu.of("뇨끼", MenuCategory.FRENCH),
                Menu.of("끼슈", MenuCategory.FRENCH),
                Menu.of("프렌치 토스트", MenuCategory.FRENCH),
                Menu.of("바게트", MenuCategory.FRENCH),
                Menu.of("스파게티", MenuCategory.FRENCH),
                Menu.of("피자", MenuCategory.FRENCH),
                Menu.of("파니니", MenuCategory.FRENCH)
        ));
    }
}