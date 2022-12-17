package menu.view;

public class OutputView {

    public void printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.");
        printEnter();
    }

    public void printCoachNamesInputMessage(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printCoachNamesInputMessage() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)");
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

