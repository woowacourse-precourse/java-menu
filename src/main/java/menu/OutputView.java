package menu;

public class OutputView {
    public static void printRecommendStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printRecommendResult(WeekMenu weekMenu, Coaches coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | " + weekMenu.getDayMenu(0).getCategory() + " | "
                + weekMenu.getDayMenu(1).getCategory() + " | "
                + weekMenu.getDayMenu(2).getCategory() + " | "
                + weekMenu.getDayMenu(3).getCategory() + " | "
                + weekMenu.getDayMenu(4).getCategory()
                + " ]");
        for (Coach coach : coaches.getCoaches()) {
            System.out.println("[ " +
                    coach.getName() + " | " +
                    coach.getRecommendedMenus().get(0) + " | " +
                    coach.getRecommendedMenus().get(1) + " | " +
                    coach.getRecommendedMenus().get(2) + " | " +
                    coach.getRecommendedMenus().get(3) + " | " +
                    coach.getRecommendedMenus().get(4) +
                    " ]");
        }
        System.out.println("추천을 완료했습니다.");


    }
}
