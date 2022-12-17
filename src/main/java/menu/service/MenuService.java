package menu.service;

import menu.domain.Category;
import menu.domain.Menus;
import menu.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private MenuRepository menuRepository = new MenuRepository();

    public void initMenus() {
        initJapanese();
        initKorean();
        initChinese();
        initAsian();
        initWestern();
    }

    private void initJapanese() {
        Menus javaneseMenus = Menus.from(List.of("규동", "우동", "미소시루", "스시",
                "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menuRepository.addMenus(Category.JAPANESE, javaneseMenus);
    }

    private void initKorean() {
        Menus koreanMenus = Menus.from(List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥",
                "칼국수", "불고기", "떡볶이", "제육볶음"));
        menuRepository.addMenus(Category.KOREAN, koreanMenus);
    }

    private void initChinese() {
        Menus chineseMenus = Menus.from(List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부",
                "탕수육", "토마토 달걀볶음", "고추잡채"));
        menuRepository.addMenus(Category.CHINESE, chineseMenus);
    }

    private void initAsian() {
        Menus asianMenus = Menus.from(List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menuRepository.addMenus(Category.ASIAN, asianMenus);
    }

    private void initWestern() {
        Menus westernMenus = Menus.from(List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트",
                "바게트", "스파게티", "피자", "파니니"));
        menuRepository.addMenus(Category.WESTERN, westernMenus);
    }

    public boolean isExistsMenu(String name) {
        return menuRepository.isExistsMenu(name);
    }
}