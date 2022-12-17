package menu.domain;

import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuException;
import menu.util.Categori;

import java.util.List;

public class MenuDomain {
    private Menu menu;
    private Coachs coachs;
    private DaysRecommand daysRecommand;
    public void initMenu() {
        menu = new Menu();
        menu.addMenu(Categori.JAPAN.getName(), List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menu.addMenu(Categori.KOREA.getName(), List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menu.addMenu(Categori.CHINA.getName(), List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menu.addMenu(Categori.ASIAN.getName(), List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menu.addMenu(Categori.WESTERN.getName(), List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public void initDays() {
        daysRecommand = DaysRecommand.of();
    }

    public void initCoachs(List<String> userList) {
        coachs = Coachs.of(userList);
        daysRecommand.initCoachNames(coachs);
    }

    public List<Coach> getCoachs() {
        return coachs.getCoachs();
    }

    /**
     * 메뉴에 없는 값 입력시 예외
     * @param foods
     * @return
     */
    public List<String> checkAndFoods(List<String> foods) {
        MenuException.checkMenuList(menu, foods);
        return foods;
    }

    public void initFoods(Coach coach, List<String> foods) {
        coach.initFoods(foods);
    }

    /**
     * 메뉴 추천을 위한 동작 함수
     */
    public void doRecommand() {
        for (Day day : daysRecommand.getDays()) {
            eachDay();
        }
        // 5일 동안 같은 카테고리가 3회 이상 중복시 다시
        // 각 사람은 같은 메뉴 안된다.
    }

    /**
     * 각 요일
     */
    public void eachDay() {
        daysRecommand.setDayCategori(getCategoriName());

        // 각 코치가 먹을 메뉴 추천
    }

    /**
     * 카테고리가 2개 이하일 때까지 Random값 입력받는 함수
     * @return
     */
    public String getCategoriName() {
        boolean canUesName = false;
        String name = null;
        while (!canUesName) {
            name = Menu.getRandomCategoriName();
            canUesName = daysRecommand.isCategoriMax(name);
        }
        return name;
    }
}
