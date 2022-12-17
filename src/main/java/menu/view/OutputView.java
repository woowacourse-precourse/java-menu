package menu.view;

public class OutputView {

    public void printResultMessage() {
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printCategoryResult(String categoryResult) {
        System.out.println(categoryResult);
    }

    public void printSelectedMenuResult(String menuResult) {
        System.out.println(menuResult);
    }
}
