package menu.controller;

import menu.domain.Category;
import menu.domain.MenuRepository;

public class MenuMaker {

    public void makeMenus() {
        makeJapaneseMenu();
        makeKoreanMenu();
        makeChineseMenu();
        makeAsianMenu();
        makeWesternMenu();
    }

    private void makeJapaneseMenu() {
        MenuRepository.addMenu("규동", Category.JAPANESE);
        MenuRepository.addMenu("우동", Category.JAPANESE);
        MenuRepository.addMenu("미소시루", Category.JAPANESE);
        MenuRepository.addMenu("스시", Category.JAPANESE);
        MenuRepository.addMenu("가츠동", Category.JAPANESE);
        MenuRepository.addMenu("오니기리", Category.JAPANESE);
        MenuRepository.addMenu("하이라이스", Category.JAPANESE);
        MenuRepository.addMenu("라멘", Category.JAPANESE);
        MenuRepository.addMenu("오코노미야끼", Category.JAPANESE);
    }

    private void makeKoreanMenu() {
        MenuRepository.addMenu("김밥", Category.KOREAN);
        MenuRepository.addMenu("김치찌개", Category.KOREAN);
        MenuRepository.addMenu("쌈밥", Category.KOREAN);
        MenuRepository.addMenu("된장찌개", Category.KOREAN);
        MenuRepository.addMenu("비빔밥", Category.KOREAN);
        MenuRepository.addMenu("칼국수", Category.KOREAN);
        MenuRepository.addMenu("불고기", Category.KOREAN);
        MenuRepository.addMenu("떡볶이", Category.KOREAN);
        MenuRepository.addMenu("제육볶음", Category.KOREAN);
    }

    private void makeChineseMenu() {
        MenuRepository.addMenu("깐풍기", Category.CHINESE);
        MenuRepository.addMenu("볶음면", Category.CHINESE);
        MenuRepository.addMenu("동파육", Category.CHINESE);
        MenuRepository.addMenu("짜장면", Category.CHINESE);
        MenuRepository.addMenu("짬뽕", Category.CHINESE);
        MenuRepository.addMenu("마파두부", Category.CHINESE);
        MenuRepository.addMenu("탕수육", Category.CHINESE);
        MenuRepository.addMenu("토마토 달걀볶음", Category.CHINESE);
        MenuRepository.addMenu("고추잡채", Category.CHINESE);
    }

    private void makeAsianMenu() {
        MenuRepository.addMenu("팟타이", Category.ASIAN);
        MenuRepository.addMenu("카오 팟", Category.ASIAN);
        MenuRepository.addMenu("나시고렝", Category.ASIAN);
        MenuRepository.addMenu("파인애플 볶음밥", Category.ASIAN);
        MenuRepository.addMenu("쌀국수", Category.ASIAN);
        MenuRepository.addMenu("똠얌꿍", Category.ASIAN);
        MenuRepository.addMenu("반미", Category.ASIAN);
        MenuRepository.addMenu("월남쌈", Category.ASIAN);
        MenuRepository.addMenu("분짜", Category.ASIAN);
    }

    private void makeWesternMenu() {
        MenuRepository.addMenu("라자냐", Category.WESTERN);
        MenuRepository.addMenu("그라탱", Category.WESTERN);
        MenuRepository.addMenu("뇨끼", Category.WESTERN);
        MenuRepository.addMenu("끼슈", Category.WESTERN);
        MenuRepository.addMenu("프렌치 토스트", Category.WESTERN);
        MenuRepository.addMenu("바게트", Category.WESTERN);
        MenuRepository.addMenu("스파게티", Category.WESTERN);
        MenuRepository.addMenu("피자", Category.WESTERN);
        MenuRepository.addMenu("파나니", Category.WESTERN);
    }
}
