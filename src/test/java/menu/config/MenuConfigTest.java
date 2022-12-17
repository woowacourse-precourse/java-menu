package menu.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.Category;
import menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuConfigTest {

    @DisplayName("설정을 완료하면 메뉴 저장소에 메뉴가 저장된다.")
    @Test
    void configure() {
        MenuConfig.configure();

        configureJapanTest();
        configureKoreaTest();
        configureChinaTest();
        configureAsiaTest();
        configureAmericaTest();
    }

    void configureJapanTest() {
        Category category = Category.JAPAN;

        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus).containsExactly(
                "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    }

    void configureKoreaTest() {
        Category category = Category.KOREA;

        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus).containsExactly(
                "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    }

    void configureChinaTest() {
        Category category = Category.CHINA;

        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus).containsExactly(
                "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    }

    void configureAsiaTest() {
        Category category = Category.ASIA;

        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus).containsExactly(
                "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    }

    void configureAmericaTest() {
        Category category = Category.AMERICA;

        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus).containsExactly(
                "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
    }
}