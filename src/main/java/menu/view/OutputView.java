package menu.view;


public class OutputView {

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(String recommendCategory, String recommendMenu) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(recommendCategory);
        System.out.println(recommendMenu);
    }

    public void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
