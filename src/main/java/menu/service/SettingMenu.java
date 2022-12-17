package menu.service;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;

public class SettingMenu {

    public void setMenus() {
        setMenuAboutJapan();
        setMenuAboutKorea();
        setMenuAboutChina();
        setMenuAboutAsia();
        setMenuAboutWest();
    }

    private void setMenuAboutJapan() {
        // 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
        MenuRepository.addMenu(new Menu(Category.JAPAN, "규동"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "우동"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "미소시루"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "스시"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "가츠동"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "오니기리"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "하이라이스"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "라멘"));
        MenuRepository.addMenu(new Menu(Category.JAPAN, "오코노미야끼"));
    }

    private void setMenuAboutKorea() {
        // 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
        MenuRepository.addMenu(new Menu(Category.KOREA, "김밥"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "김치찌개"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "쌈밥"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "된장찌개"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "비빔밥"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "칼국수"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "불고기"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "떡볶이"));
        MenuRepository.addMenu(new Menu(Category.KOREA, "제육볶음"));
    }

    private void setMenuAboutChina() {
        // 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
        MenuRepository.addMenu(new Menu(Category.CHINA, "깐풍기"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "볶음면"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "동파육"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "짜장면"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "짬뽕"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "마파두부"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "탕수육"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "토마토 달걀볶음"));
        MenuRepository.addMenu(new Menu(Category.CHINA, "고추잡채"));
    }

    private void setMenuAboutAsia() {
        // 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
        MenuRepository.addMenu(new Menu(Category.ASIA, "팟타이"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "카오 팟"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "나시고렝"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "파인애플 볶음밥"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "쌀국수"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "똠얌꿍"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "반미"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "월남쌈"));
        MenuRepository.addMenu(new Menu(Category.ASIA, "분짜"));
    }

    private void setMenuAboutWest() {
        //  라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
        MenuRepository.addMenu(new Menu(Category.WEST, "라자냐"));
        MenuRepository.addMenu(new Menu(Category.WEST, "그라탱"));
        MenuRepository.addMenu(new Menu(Category.WEST, "뇨끼"));
        MenuRepository.addMenu(new Menu(Category.WEST, "끼슈"));
        MenuRepository.addMenu(new Menu(Category.WEST, "프렌치 토스트"));
        MenuRepository.addMenu(new Menu(Category.WEST, "바게트"));
        MenuRepository.addMenu(new Menu(Category.WEST, "스파게티"));
        MenuRepository.addMenu(new Menu(Category.WEST, "피자"));
        MenuRepository.addMenu(new Menu(Category.WEST, "파니니"));
    }

}
