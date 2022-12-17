package menu;

import java.util.List;
import menu.domain.menu.Category;
import menu.domain.menu.entity.Menu;
import menu.domain.menu.repository.MenuRepository;

public class MenuRepositoryInitializer {

    private static final List<Menu> JAPANESE_MENU = List.of(
            new Menu("규동", Category.JAPANESE),
            new Menu("우동", Category.JAPANESE),
            new Menu("미소시루", Category.JAPANESE),
            new Menu("스시", Category.JAPANESE),
            new Menu("가츠동", Category.JAPANESE),
            new Menu("오니기리", Category.JAPANESE),
            new Menu("하이라이스", Category.JAPANESE),
            new Menu("라멘", Category.JAPANESE),
            new Menu("오코노미야끼", Category.JAPANESE));

    private static final List<Menu> KOREAN_MENU = List.of(
            new Menu("김밥", Category.KOREAN),
            new Menu("김치찌개", Category.KOREAN),
            new Menu("쌈밥", Category.KOREAN),
            new Menu("된장찌개", Category.KOREAN),
            new Menu("비빔밥", Category.KOREAN),
            new Menu("칼국수", Category.KOREAN),
            new Menu("불고기", Category.KOREAN),
            new Menu("떡볶이", Category.KOREAN),
            new Menu("제육볶음", Category.KOREAN));

    private static final List<Menu> CHINESE_MENU = List.of(
            new Menu("깐풍기", Category.CHINESE),
            new Menu("볶음면", Category.CHINESE),
            new Menu("동파육", Category.CHINESE),
            new Menu("짜장면", Category.CHINESE),
            new Menu("짬뽕", Category.CHINESE),
            new Menu("마파두부", Category.CHINESE),
            new Menu("탕수육", Category.CHINESE),
            new Menu("토마토 달걀볶음", Category.CHINESE),
            new Menu("고추잡채", Category.CHINESE));

    private static final List<Menu> ASIAN_MENU = List.of(
            new Menu("팟타이", Category.ASIAN),
            new Menu("카오 팟", Category.ASIAN),
            new Menu("나시고렝", Category.ASIAN),
            new Menu("파인애플 볶음밥", Category.ASIAN),
            new Menu("쌀국수", Category.ASIAN),
            new Menu("똠얌꿍", Category.ASIAN),
            new Menu("반미", Category.ASIAN),
            new Menu("월남쌈", Category.ASIAN),
            new Menu("분짜", Category.ASIAN));

    private static final List<Menu> WESTERN_MENU = List.of(
            new Menu("라자냐", Category.WESTERN),
            new Menu("그라탱", Category.WESTERN),
            new Menu("뇨끼", Category.WESTERN),
            new Menu("끼슈", Category.WESTERN),
            new Menu("프렌치 토스트", Category.WESTERN),
            new Menu("바게트", Category.WESTERN),
            new Menu("스파게티", Category.WESTERN),
            new Menu("피자", Category.WESTERN),
            new Menu("파니니", Category.WESTERN));

    private static final MenuRepository MENU_REPOSITORY = new MenuRepository();

    public MenuRepositoryInitializer() {
        JAPANESE_MENU.forEach(MENU_REPOSITORY::save);
        KOREAN_MENU.forEach(MENU_REPOSITORY::save);
        CHINESE_MENU.forEach(MENU_REPOSITORY::save);
        ASIAN_MENU.forEach(MENU_REPOSITORY::save);
        WESTERN_MENU.forEach(MENU_REPOSITORY::save);
    }

    public MenuRepository getMenuRepository() {
        return MENU_REPOSITORY;
    }
}
