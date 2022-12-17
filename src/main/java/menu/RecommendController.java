package menu;

import camp.nextstep.edu.missionutils.Randoms;


public class RecommendController {
    private final Coaches coaches;
    private final WeekMenu weekMenu;
    private final Categories categories;

    public RecommendController(Coaches coaches) {
        this.coaches = coaches;
        this.weekMenu = new WeekMenu();
        this.categories = new Categories();
    }

    public void recommendStart() {
        initCategories();
        settingWeekCategory();
        for (int i = 0; i < 5; i++) {
            for (Coach e : coaches.getCoaches())
                settingRecommendMenu(i, e);
        }
        OutputView.printRecommendResult(weekMenu, coaches);
    }

    public void settingWeekCategory() {
        initWeekMenu();
        for (int i = 0; i < 5; i++) {
            String category = settingDayCategory();
            weekMenu.getDayMenu(i).setCategory(category);
        }

    }

    public void initWeekMenu() {
        weekMenu.getWeekMenu().add(new DayMenu("월요일"));
        weekMenu.getWeekMenu().add(new DayMenu("화요일"));
        weekMenu.getWeekMenu().add(new DayMenu( "수요일"));
        weekMenu.getWeekMenu().add(new DayMenu("목요일"));
        weekMenu.getWeekMenu().add(new DayMenu("금요일"));
    }

    public String settingDayCategory() {
        String newCategory = categories.getCategoryNames().get(Randoms.pickNumberInRange(1, 5) - 1);
        if (Validator.recommendCategoryCheck(weekMenu, newCategory)) {
            settingDayCategory();
        }
        return newCategory;
    }

    private void initCategories() {
        categories.getCategories().add(new Category("일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"));
        categories.getCategories().add(new Category("한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"));
        categories.getCategories().add(new Category("중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"));
        categories.getCategories().add(new Category("아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"));
        categories.getCategories().add(new Category("양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));
    }

    public void settingRecommendMenu(int index, Coach coach) {
        if (weekMenu.getDayMenu(index).getCategory().equals("일식"))
            recommendInJapanese(coach);//월요일
        if (weekMenu.getDayMenu(index).getCategory().equals("한식"))
            recommendInKorean(coach);//화요일
        if (weekMenu.getDayMenu(index).getCategory().equals("중식"))
            recommendInChinese(coach);//수요일
        if (weekMenu.getDayMenu(index).getCategory().equals("아시안"))
            recommendInAsian(coach);//목요일
        if (weekMenu.getDayMenu(index).getCategory().equals("양식"))
            recommendInWestern(coach);//금요일
    }

    public void recommendInJapanese(Coach coach) {
        String JapaneseMenu = Randoms.shuffle(categories.getCategories().get(0).getMenus()).get(0);
        if (Validator.recommendMenuCheck(JapaneseMenu, coach))
            recommendInJapanese(coach);
        coach.addRecommendedMenus(JapaneseMenu);
    }

    public void recommendInKorean(Coach coach) {
        String KoreanMenu = Randoms.shuffle(categories.getCategories().get(1).getMenus()).get(0);
        if (Validator.recommendMenuCheck(KoreanMenu, coach))
            recommendInKorean(coach);

        coach.addRecommendedMenus(KoreanMenu);
    }

    public void recommendInChinese(Coach coach) {
        String ChineseMenu = Randoms.shuffle(categories.getCategories().get(2).getMenus()).get(0);
        if (Validator.recommendMenuCheck(ChineseMenu, coach))
            recommendInChinese(coach);

        coach.addRecommendedMenus(ChineseMenu);
    }

    public void recommendInAsian(Coach coach) {
        String AsianMenu = Randoms.shuffle(categories.getCategories().get(3).getMenus()).get(0);
        if (Validator.recommendMenuCheck(AsianMenu, coach))
            recommendInAsian(coach);

        coach.addRecommendedMenus(AsianMenu);
    }

    public void recommendInWestern(Coach coach) {
        String WesternMenu = Randoms.shuffle(categories.getCategories().get(4).getMenus()).get(0);
        if (Validator.recommendMenuCheck(WesternMenu, coach))
            recommendInWestern(coach);
        coach.addRecommendedMenus(WesternMenu);
    }
}
