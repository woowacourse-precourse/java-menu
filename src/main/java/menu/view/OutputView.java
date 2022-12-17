package menu.view;

public class OutputView {

    public void printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.");
        printEnter();
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printEnter() {
        System.out.println();
    }

}

